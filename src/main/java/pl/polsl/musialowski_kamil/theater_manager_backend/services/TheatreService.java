package pl.polsl.musialowski_kamil.theater_manager_backend.services;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelUserDto;

import java.util.Set;

public interface TheatreService {

    CreatedTheatreDto create(Long creatorId, TheatreCreateDto theatreCreateDto);

    Set<TheatresListDto> getTheatersOfManager(Long managerId);

    TheatrePersonelDto addPersonel(String email, Long theaterId, String role);

    Set<TheatrePersonelUserDto> getActors(Long theatreId);

    HallDto addHall(HallCreateDto hallCreateDto, Long theaterId);

    Set<HallListDto> getTheatersHalls(Long theaterId);

    CreatedTheatreDto getTheater(Long theaterId);

    CreatedTheatreDto editTheater(TheatreEditDto theatreEditDto);

    Set<TheatrePersonelListDto> getPersonel(Long theaterId);

    Long deletePersonel(Long personelId);
}
