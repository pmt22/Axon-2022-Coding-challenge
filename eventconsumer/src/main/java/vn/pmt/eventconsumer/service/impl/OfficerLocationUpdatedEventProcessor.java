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
public class OfficerLocationUpdatedEventProcessor extends AbstractEventProcessor<Event.OfficerLocationUpdated> {

    @Override
    protected void processEvent(Event.OfficerLocationUpdated event) {
        var officerOptional = repository.getOfficer(event.officerId());

        Officer officer;

        if (officerOptional.isPresent()) {
            officer = officerOptional.get();
            officer.setLoc(event.loc());
        } else {
            officer = Officer.builder()
                .id(event.officerId())
                .loc(event.loc())
                .build();
            repository.save(officer);
        }
        log.info("Location of Officer {} is updated!", officer.getId());
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.OfficerLocationUpdated;
    }
}
