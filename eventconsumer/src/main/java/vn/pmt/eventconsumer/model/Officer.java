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
public class Officer {
    private Integer id;

    private String badgeName;

    private Location loc;

    @JsonIgnore
    private boolean isOnline;
}
