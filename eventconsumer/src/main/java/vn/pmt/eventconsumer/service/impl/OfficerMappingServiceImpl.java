package vn.pmt.eventconsumer.service.impl;

import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.datasource.OfficerIncidentRepository;
import vn.pmt.eventconsumer.model.Incident;
import vn.pmt.eventconsumer.model.Location;
import vn.pmt.eventconsumer.service.OfficerIncidentService;
import vn.pmt.eventconsumer.service.OfficerMappingService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OfficerMappingServiceImpl implements OfficerMappingService {
    private final OfficerIncidentRepository repository;
    private final OfficerIncidentService officerIncidentService;

    @Override
    public void mapOfficer() {
        var availableOfficers = repository.getAllOfficers().stream()
            .filter(officer -> officer.isOnline() && officer.getLoc() != null && repository.officerHasNotBeenAssignedAnIncident(officer))
            .collect(Collectors.toList());

        var incidents = repository.getAllIncidents().stream()
            .sorted(Comparator.comparing(Incident::getOccurredTime))
            .collect(Collectors.toList());

        for (Incident incident : incidents) {
            availableOfficers.stream()
                .min(Comparator.comparing(officer -> distanceBetween(incident.getLoc(), officer.getLoc())))
                .ifPresent(officer -> officerIncidentService.assignIncidentToOfficer(incident, officer));
        }
    }

    private static Double distanceBetween(Location locationA, Location locationB) {
        return Math.sqrt(Math.pow(locationA.getX() - locationB.getX(), 2) + Math.pow(locationA.getY() - locationB.getY(), 2));
    }
}
