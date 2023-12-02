package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservation;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link EventReservation}
 */
public record EventReservationsDto(Long id, LocalDateTime startDate, LocalDateTime endDate, EventTypeEnum eventType,
                                   HallListDto hall, TheatreArtDto theatreArt,
                                   Set<UserListDto> users) implements Serializable {
}