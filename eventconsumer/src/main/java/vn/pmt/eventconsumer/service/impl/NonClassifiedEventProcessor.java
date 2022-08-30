package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import vn.pmt.eventconsumer.model.Event;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public class NonClassifiedEventProcessor extends AbstractEventProcessor<Event.NonClassified> {

    @Override
    protected void processEvent(Event.NonClassified event) {

    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.NonClassified;
    }
}
