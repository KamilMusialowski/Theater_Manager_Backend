package pl.polsl.musialowski_kamil.theater_manager_backend.services;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreationDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.artInvolvedPersonelDtos.ArtInvolvedPersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;
import pl.polsl.musialowski_kamil.theater_manager_backend.requestsDataModels.ArtInvolvedPersonelModels.ActorCharacterAssignedModel;

import java.util.Set;

public interface TheatreArtService {
    TheatreArtCreatedDto create(TheatreArtCreationDto theatreArtCreationDto);

    TheatreArt saveBasicArt(TheatreArt theatreArt);

    Set<ArtInvolvedPersonelDto> getDirectorsArts(Long directorId);

    TheatreArtDto getArt(Long artId);

    Set<ArtInvolvedPersonelDto> assignActorsToRoles(ActorCharacterAssignedModel actorCharacterAssignedModel);

    Set<ArtInvolvedPersonelDto> getRolesAssigment(Long artId);
}
