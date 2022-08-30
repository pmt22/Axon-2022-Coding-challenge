package vn.pmt.eventconsumer.datasource;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

import lombok.Getter;
import vn.pmt.eventconsumer.model.Incident;
import vn.pmt.eventconsumer.model.Officer;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public final class OfficerIncidentRepository {
    private final Map<Integer, Officer> officers = new ConcurrentHashMap<>();

    private final Map<Integer, Incident> incidents = new ConcurrentHashMap<>();

    @Getter
    private final Map<Officer, Incident> assignedOfficerIncident = new ConcurrentHashMap<>();

    public Collection<Officer> getAllOfficers() {
        return officers.values();
    }
    public Optional<Officer> getOfficer(Integer id) {
        return Optional.ofNullable(officers.get(id));
    }

    public Officer save(Officer officer) {
        return officers.putIfAbsent(officer.getId(), officer);
    }

    public Collection<Incident> getAllIncidents() {
        return incidents.values();
    }

    public Incident save(Incident incident) {
        return incidents.putIfAbsent(incident.getId(), incident);
    }

    public Incident getIncident(Integer id) {
        return incidents.get(id);
    }

    public void removeIncident(Integer id) {
        incidents.remove(id);
    }

    public boolean officerHasNotBeenAssignedAnIncident(Officer officer) {
        return !officerHasBeenAssignedAnIncident(officer);
    }

    public boolean officerHasBeenAssignedAnIncident(Officer officer) {
        return assignedOfficerIncident.containsKey(officer);
    }

    public void saveAssignedOfficerIncident(Officer officer, Incident incident) {
        assignedOfficerIncident.put(officer, incident);
    }

    public Incident removeAssignedOfficerIncident(Officer officer) {
        return assignedOfficerIncident.remove(officer);
    }
}
