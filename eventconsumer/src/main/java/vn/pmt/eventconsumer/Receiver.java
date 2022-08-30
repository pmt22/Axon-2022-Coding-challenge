package vn.pmt.eventconsumer;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import vn.pmt.eventconsumer.service.EventConsumingService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
@RequiredArgsConstructor
public class Receiver {
    private final EventFactory eventFactory;
    private final EventConsumingService service;

    public void receive(String message) {
        System.out.println(message);
        try {
            eventFactory.createEvent(message)
                .ifPresent(service::processEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error occurs while creating event", e);
        }
    }
}
