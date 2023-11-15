package pl.polsl.musialowski_kamil.theater_manager_backend.services;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreDirectorDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelUserDto;

import java.util.Set;

public interface TheatreService {

    CreatedTheatreDto create(Long creatorId, TheatreCreateDto theatreCreateDto);

    Set<TheatresListDto> getTheatersOfManager(Long managerId);

    TheatrePersonelDto addPersonel(String email, Long theaterId, String role);

    Set<TheatrePersonelUserDto> getActors(Long theatreId);
}
