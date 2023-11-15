package pl.polsl.musialowski_kamil.theater_manager_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelUserDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.TheaterPersonelDataModels.TPersonelAddModel;
import pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.TheatreDataModels.TheatreCreateModel;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.TheatreService;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/theater")
public class TheatreControler {

    private final TheatreService theatreService;

    public TheatreControler(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreatedTheatreDto> createTheater(@RequestBody TheatreCreateModel theatreCreateModel) {
        CreatedTheatreDto theater = this.theatreService.create(
                theatreCreateModel.getUserCreatorId(),
                theatreCreateModel.getTheatreModel());
        return ResponseEntity.created(URI.create("/theatres" + theater.id())).body(theater);
    }

    @GetMapping("/getTheatersOfManager")
    public ResponseEntity<Set<TheatresListDto>> getTheatersOfManager(@RequestParam Long managerId) {
        Set<TheatresListDto> managersTheaters = theatreService.getTheatersOfManager(managerId);
        return ResponseEntity.ok(managersTheaters);
    }

    @PostMapping("/addPersonel")
    public ResponseEntity<TheatrePersonelDto> addTheatrePersonel(@RequestBody TPersonelAddModel tPersonelAddModel) {
        TheatrePersonelDto addedPersonel = theatreService.addPersonel(tPersonelAddModel.personelEmail(), tPersonelAddModel.theaterId(), tPersonelAddModel.role());
        return ResponseEntity.ok(addedPersonel);
    }

    @GetMapping("/getActors")
    public ResponseEntity<Set<TheatrePersonelUserDto>> getTheatreActors(@RequestParam Long theatreId) {
        Set<TheatrePersonelUserDto> theatrePersonelUserDtos =theatreService.getActors(theatreId);
        return ResponseEntity.ok(theatrePersonelUserDtos);
    }

}
