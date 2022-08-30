package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import vn.pmt.eventconsumer.model.Event;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public class OfficerGoesOfflineEventProcessor extends AbstractEventProcessor<Event.OfficerGoesOffline> {

    @Override
    protected void processEvent(Event.OfficerGoesOffline event) {

    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.OfficerGoesOffline;
    }
}
