package vn.pmt.eventconsumer.service;

import vn.pmt.eventconsumer.model.Event;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
public interface EventConsumingService {

    void processEvent(Event event);

}
