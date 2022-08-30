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
@RequiredArgsConstructor
public class IncidentResolvedEventProcessor implements EventProcessor<Event.IncidentResolved> {
    private final OfficerIncidentRepository repository;

    @Override
    public void process(Event.IncidentResolved event) {
        
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.IncidentResolved;
    }
}
