package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservation;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link EventReservation}
 */
public record EventReservationsListDto(LocalDateTime startDate, LocalDateTime endDate, EventTypeEnum eventType,
                                       HallDto hall, TheatreArtCreatedDto theatreArt) implements Serializable {
}