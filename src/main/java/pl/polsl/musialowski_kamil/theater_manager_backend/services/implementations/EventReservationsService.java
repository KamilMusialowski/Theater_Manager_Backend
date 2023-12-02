package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.EventReservationsMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.EventReservationsRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.HallRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.TheatreArtRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventReservationsService {

    private final EventReservationsRepository eventReservationsRepository;
    private final HallRepository hallRepository;
    private final TheatreArtRepository theatreArtRepository;
    private final UserRepository userRepository;
    private final EventReservationsMapper eventReservationsMapper;

    public EventReservationsService(EventReservationsRepository eventReservationsRepository, HallRepository hallRepository, TheatreArtRepository theatreArtRepository, UserRepository userRepository, EventReservationsMapper eventReservationsMapper) {
        this.eventReservationsRepository = eventReservationsRepository;
        this.hallRepository = hallRepository;
        this.theatreArtRepository = theatreArtRepository;
        this.userRepository = userRepository;
        this.eventReservationsMapper = eventReservationsMapper;
    }

    public EventReservationsDto createEventReservation(LocalDateTime startDate, LocalDateTime endDate, Long hallId, Long artId, EventTypeEnum eventType) {
        Hall hall = hallRepository.findById(hallId).get();
        TheatreArt art = theatreArtRepository.findById(artId).get();
        Set<User> users = art.getInvolvedPersonel().stream().map(ArtInvolvedPersonel::getInvolvedUser).collect(Collectors.toSet());
        EventReservation eventReservation = new EventReservation();
        eventReservation.setStartDate(startDate);
        eventReservation.setEndDate(endDate);
        eventReservation.setHall(hall);
        eventReservation.setTheatreArt(art);
        eventReservation.setEventType(eventType);
        eventReservation.setUsers(users);
        eventReservation = eventReservationsRepository.save(eventReservation);
        return eventReservationsMapper.toDto(eventReservation);
    }

    public Set<EventReservationsListDto> getUserEvents(Long userId) {
        Set<EventReservation> events = eventReservationsRepository.getUserEvents(userId).get();
        Set<EventReservationsListDto> result = events.stream().map(eventReservationsMapper::toDto1).collect(Collectors.toSet());
        return result;
    }
}
