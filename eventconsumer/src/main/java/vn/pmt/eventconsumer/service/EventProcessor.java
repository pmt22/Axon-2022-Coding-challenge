package vn.pmt.eventconsumer.service;

import vn.pmt.eventconsumer.model.Event;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
public interface EventProcessor<E extends Event> {
    void process(Event event);

    boolean canProcess(Event event);
}
