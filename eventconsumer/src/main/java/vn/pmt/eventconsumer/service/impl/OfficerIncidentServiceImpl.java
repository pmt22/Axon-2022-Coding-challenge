package vn.pmt.eventconsumer.service.impl;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.datasource.OfficerIncidentRepository;
import vn.pmt.eventconsumer.model.APIResponse;
import vn.pmt.eventconsumer.model.Incident;
import vn.pmt.eventconsumer.model.Officer;
import vn.pmt.eventconsumer.service.OfficerIncidentService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OfficerIncidentServiceImpl implements OfficerIncidentService {
    private final OfficerIncidentRepository repository;

    @Override
    public void assignIncidentToOfficer(Incident incident, Officer officer) {
        incident.setOfficerId(officer.getId());
        repository.removeIncident(incident.getId());
        repository.saveAssignedOfficerIncident(officer, incident);
        log.info("Assign incident {} to officer {}", incident.getId(), officer.getId());
    }

    @Override
    public void unassignIncidentToOfficer(Integer incidentId) {
        var assignedOfficer = repository.getAssignedOfficerIncident().entrySet().stream()
            .filter(entry -> Objects.equals(entry.getValue().getId(), incidentId))
            .findAny()
            .map(Map.Entry::getKey);

        assignedOfficer.ifPresent(repository.getAssignedOfficerIncident()::remove);
        log.info("Unassign incident {}", incidentId);
    }

    @Override
    public void unassignIncidentToOfficerGoesOffline(Integer officerId) {
        repository.getOfficer(officerId)
            .map(repository::removeAssignedOfficerIncident)
            .ifPresent(incident -> {
                incident.setOfficerId(null);
                repository.save(incident);
                log.info("Unassign incident of an officer that went offline!");
            });
    }

    @Override
    public APIResponse getState() {
        APIResponse.Data data = new APIResponse.Data();
        data.setOfficers(repository.getAllOfficers().stream().toList());
        data.setIncidents(Stream.concat(repository.getAllIncidents().stream(), repository.getAssignedOfficerIncident().values().stream()).toList());
        return new APIResponse(data, null);
    }
}
