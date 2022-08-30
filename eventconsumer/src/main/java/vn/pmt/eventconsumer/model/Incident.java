package vn.pmt.eventconsumer.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mai Thiên Phú
 * @since 30/08/2022
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Incident {
    private Integer id;

    private String codeName;

    private Location loc;

    private Integer officerId;

    @JsonIgnore
    private boolean isResolved;

    @JsonIgnore
    private LocalDateTime occurredTime = LocalDateTime.now();
}
