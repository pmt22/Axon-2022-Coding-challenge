package vn.pmt.eventconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Incident {
    private Integer id;

    private String codeName;

    private Location loc;

    private Integer officerId;

    @JsonIgnore
    private boolean isResolved;
}
