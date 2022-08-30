package vn.pmt.eventconsumer.service.impl;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.model.Incident;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Slf4j
@Component
public class IncidentOccurredEventProcessor extends AbstractEventProcessor<Event.IncidentOccurred> {

    @Override
    protected void processEvent(Event.IncidentOccurred event) {
        Incident incident = Incident.builder()
            .id(event.incidentId())
            .codeName(event.codeName())
            .loc(event.loc())
            .build();

        repository.save(incident);
        log.info("Incident {} has occurred", event.incidentId());
    }

    @Override
    public boolean canProcess(Event event) {
        return event instanceof Event.IncidentOccurred;
    }
}
