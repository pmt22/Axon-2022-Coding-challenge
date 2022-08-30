package vn.pmt.eventconsumer.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.pmt.eventconsumer.datasource.OfficerIncidentRepository;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.service.EventConsumingService;
import vn.pmt.eventconsumer.service.EventProcessor;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Service
@RequiredArgsConstructor
public class EventConsumingServiceImpl implements EventConsumingService {
    private final List<EventProcessor<Event>> eventProcessors;

    @Override
    public void processEvent(Event event) {
        eventProcessors.stream()
            .filter(processor -> processor.canProcess(event))
            .findAny()
            .ifPresent(processor -> processor.process(event));
    }
}
