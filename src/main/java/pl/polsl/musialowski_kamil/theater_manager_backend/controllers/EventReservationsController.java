package pl.polsl.musialowski_kamil.theater_manager_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;
import pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.RehearsalDataModels.RehearsalCreateDataModel;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations.EventReservationsService;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/events")
public class EventReservationsController {

    private final EventReservationsService eventReservationsService;

    public EventReservationsController(EventReservationsService eventReservationsService) {
        this.eventReservationsService = eventReservationsService;
    }

    @PostMapping("/create")
    public ResponseEntity<EventReservationsDto> createRehearsal(@RequestBody RehearsalCreateDataModel rehearsalCreateDataModel) {
        EventReservationsDto result = eventReservationsService.createEventReservation(rehearsalCreateDataModel.getStartDate(),
                rehearsalCreateDataModel.getEndDate(),
                rehearsalCreateDataModel.getHallId(),
                rehearsalCreateDataModel.getArtId(),
                EventTypeEnum.REHEARSAL);
        return ResponseEntity.created(URI.create("/events")).body(result);
    }

    @GetMapping("/user_events")
    public ResponseEntity<Set<EventReservationsListDto>> getUserEvents(@RequestParam Long userId) {
        Set<EventReservationsListDto> result = this.eventReservationsService.getUserEvents(userId);
        return ResponseEntity.ok(result);
    }
}
