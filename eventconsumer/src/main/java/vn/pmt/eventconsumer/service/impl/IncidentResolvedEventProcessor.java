package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.service.OfficerIncidentService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentResolvedEventProcessor extends AbstractEventProcessor<Event.IncidentResolved> {
    private final OfficerIncidentService officerIncidentService;

    @Override
    protected void processEvent(Event.IncidentResolved event) {
        repository.removeIncident(event.incidentId());
        officerIncidentService.unassignIncidentToOfficer(event.incidentId());
        log.info("Incident {} has been resolved.", event.incidentId());
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.IncidentResolved;
    }
}
