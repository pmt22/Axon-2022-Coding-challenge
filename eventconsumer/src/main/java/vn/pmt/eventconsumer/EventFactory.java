package vn.pmt.eventconsumer;

import java.util.Optional;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import vn.pmt.eventconsumer.model.Event;
import vn.pmt.eventconsumer.model.EventType;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
@RequiredArgsConstructor
public class EventFactory {

    private final ObjectMapper objectMapper;

    public Optional<Event> createEvent(String json) throws JsonProcessingException {
        if (json.contains(EventType.IN_OC.value())) {
            return Optional.of(objectMapper.readValue(json, Event.IncidentOccurred.class));
        }
        if (json.contains(EventType.IN_RE.value())) {
            return Optional.of(objectMapper.readValue(json, Event.IncidentResolved.class));
        }
        if (json.contains(EventType.OF_GO_ON.value())) {
            return Optional.of(objectMapper.readValue(json, Event.OfficerGoesOnline.class));
        }
        if (json.contains(EventType.OF_GO_OFF.value())) {
            return Optional.of(objectMapper.readValue(json, Event.OfficerGoesOffline.class));
        }
        if (json.contains(EventType.OF_LO_UP.value())) {
            return Optional.of(objectMapper.readValue(json, Event.OfficerLocationUpdated.class));
        }
        return Optional.of(new Event.NonClassified());
    }
}
