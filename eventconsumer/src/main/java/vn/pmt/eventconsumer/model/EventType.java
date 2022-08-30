package vn.pmt.eventconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EventType {
    IN_OC("IncidentOccurred"),
    IN_RE("IncidentResolved"),
    OF_GO_ON("OfficerGoesOnline"),
    OF_GO_OFF("OfficerGoesOffline"),
    OF_LO_UP("OfficerLocationUpdated");

    final String value;

    public String value() {
        return value;
    }
}