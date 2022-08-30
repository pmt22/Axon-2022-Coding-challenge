package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import vn.pmt.eventconsumer.datasource.OfficerIncidentRepository;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.service.EventProcessor;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public class NonClassifiedEventProcessor implements EventProcessor<Event.NonClassified> {

    @Override
    public void process(Event.NonClassified event) {

    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.NonClassified;
    }
}
