package vn.pmt.eventconsumer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vn.pmt.eventconsumer.model.APIResponse;
import vn.pmt.eventconsumer.service.OfficerIncidentService;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Controller {
    private final OfficerIncidentService officerIncidentService;

    @CrossOrigin(value = "http://localhost:8000")
    @GetMapping(value = "state", produces = "application/json")
    public APIResponse getState() {
        return officerIncidentService.getState();
    }
}
