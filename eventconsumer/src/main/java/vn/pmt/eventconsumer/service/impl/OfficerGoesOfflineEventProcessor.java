package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.model.Officer;
import vn.pmt.eventconsumer.service.OfficerIncidentService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OfficerGoesOfflineEventProcessor extends AbstractEventProcessor<Event.OfficerGoesOffline> {
    private final OfficerIncidentService officerIncidentService;

    @Override
    protected void processEvent(Event.OfficerGoesOffline event) {
        var officerOptional = repository.getOfficer(event.officerId());

        Officer officer;

        if (officerOptional.isPresent()) {
            officer = officerOptional.get();
            officer.setOnline(false);
        } else {
            officer = Officer.builder()
                .id(event.officerId())
                .build();
            repository.save(officer);
        }
        log.info("Officer {} has gone offline!", officer.getId());
        officerIncidentService.unassignIncidentToOfficerGoesOffline(officer.getId());
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.OfficerGoesOffline;
    }
}
