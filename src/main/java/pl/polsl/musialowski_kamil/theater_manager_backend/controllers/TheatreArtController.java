package pl.polsl.musialowski_kamil.theater_manager_backend.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreationDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.artInvolvedPersonelDtos.ArtInvolvedPersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations.TheatreArtService;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/art")
public class TheatreArtController {

    private final TheatreArtService theatreArtService;

    public TheatreArtController(TheatreArtService theatreArtService) {
        this.theatreArtService = theatreArtService;
    }

    @PostMapping("/create")
    public ResponseEntity<TheatreArtCreatedDto> createArt(@RequestBody TheatreArtCreationDto theatreArtCreationDto) {
        TheatreArtCreatedDto saved = theatreArtService.create(theatreArtCreationDto);
        return ResponseEntity.created(URI.create("/arts")).body(saved);
    }

    @GetMapping("/directors_arts")
    public ResponseEntity<Set<ArtInvolvedPersonelDto>> getDirectorsArtToGrid(@RequestParam Long directorId) {
        Set<ArtInvolvedPersonelDto> arts = theatreArtService.getDirectorsArts(directorId);
        return ResponseEntity.ok(arts);
    }
}
