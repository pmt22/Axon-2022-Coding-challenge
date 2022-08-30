package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import vn.pmt.eventconsumer.model.Event;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public class IncidentOccurredEventProcessor extends AbstractEventProcessor<Event.IncidentOccurred> {

    @Override
    protected void processEvent(Event.IncidentOccurred event) {

    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.IncidentOccurred;
    }
}
