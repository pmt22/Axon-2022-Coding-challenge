package vn.pmt.eventconsumer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Getter
@Setter
@AllArgsConstructor
public class APIResponse {
    private Data data;
    private Error error;

    @Getter
    @Setter
    public static class Data {
        private List<Incident> incidents;
        private List<Officer> officers;
    }

    @Getter
    @Setter
    public static class Error {
        private String code;
        private String message;
    }
}
