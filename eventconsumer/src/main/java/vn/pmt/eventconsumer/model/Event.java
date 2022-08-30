package vn.pmt.eventconsumer.model;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
public interface Event {
    record IncidentOccurred(String type, Integer incidentId, String codeName, Location loc) implements Event {}

    record IncidentResolved(String type, Integer incidentId) implements Event {}

    record OfficerGoesOnline(String type, Integer officerId, String badgeName) implements Event {}

    record OfficerGoesOffline(String type, Integer officerId) implements Event {}

    record OfficerLocationUpdated(String type, Integer officerId, Location loc) implements Event {}

    record NonClassified() implements Event {}
}
