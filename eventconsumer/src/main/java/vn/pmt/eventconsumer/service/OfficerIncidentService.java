package vn.pmt.eventconsumer.service;

import vn.pmt.eventconsumer.model.Incident;
import vn.pmt.eventconsumer.model.Officer;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
public interface OfficerIncidentService {
    void assignIncidentToOfficer(Incident incident, Officer officer);

    void unassignIncidentToOfficer(Integer incidentId);

    void unassignIncidentToOfficerGoesOffline(Integer officerId);
}
