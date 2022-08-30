package vn.pmt.eventconsumer.service.impl;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import vn.pmt.eventconsumer.datasource.OfficerIncidentRepository;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.service.EventProcessor;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
public abstract class AbstractEventProcessor<E extends Event> implements EventProcessor<E> {
    @Autowired
    protected OfficerIncidentRepository repository;

    @Override
    @SuppressWarnings("unchecked")
    public void process(Event event) {
        Validate.isTrue(canProcess(event), "Cannot process this event of type %s with %s!",
            event.getClass().getSimpleName(), getClass().getSimpleName());
        processEvent((E) event);
    }

    abstract protected void processEvent(E event);
}
