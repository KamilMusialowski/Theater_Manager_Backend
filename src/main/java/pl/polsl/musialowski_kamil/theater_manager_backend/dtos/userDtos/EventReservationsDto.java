package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservations}
 */
public record EventReservationsDto(Long id, LocalDateTime startDate, LocalDateTime endDate,
                                   EventTypeDto eventType) implements Serializable {
}