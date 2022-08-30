package vn.pmt.eventconsumer.datasource;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import vn.pmt.eventconsumer.model.Incident;
import vn.pmt.eventconsumer.model.Officer;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Component
public class OfficerIncidentRepository {
    private final Map<Integer, Officer> officers = new HashMap<>();

    private final Map<Integer, Incident> incidents = new HashMap<>();


}
