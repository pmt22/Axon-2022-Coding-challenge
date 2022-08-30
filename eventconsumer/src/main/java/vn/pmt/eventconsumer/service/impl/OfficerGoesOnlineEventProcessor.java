package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.model.Officer;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Component
public class OfficerGoesOnlineEventProcessor extends AbstractEventProcessor<Event.OfficerGoesOnline> {

    @Override
    protected void processEvent(Event.OfficerGoesOnline event) {
        var officerOptional = repository.getOfficer(event.officerId());

        Officer officer;

        if (officerOptional.isPresent()) {
            officer = officerOptional.get();
            officer.setOnline(true);
            officer.setBadgeName(event.badgeName());
        } else {
            officer = Officer.builder()
                .id(event.officerId())
                .isOnline(true)
                .badgeName(event.badgeName())
                .build();
            repository.save(officer);
        }

        log.info("Officer {} is online!", officer.getId());
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.OfficerGoesOnline;
    }
}
