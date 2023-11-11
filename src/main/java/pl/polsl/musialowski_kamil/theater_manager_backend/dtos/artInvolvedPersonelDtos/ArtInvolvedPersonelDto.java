package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.artInvolvedPersonelDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreCharacterDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto.SystemRoleDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.ArtInvolvedPersonel}
 */
public class ArtInvolvedPersonelDto implements Serializable {
    private final Long id;
    private final TheatreArtCreatedDto theatreArt;
    private final UserListDto involvedUser;
    private final SystemRoleDto role;
    private final TheatreCharacterDto character;

    public ArtInvolvedPersonelDto(Long id, TheatreArtCreatedDto theatreArt, UserListDto involvedUser, SystemRoleDto role, TheatreCharacterDto character) {
        this.id = id;
        this.theatreArt = theatreArt;
        this.involvedUser = involvedUser;
        this.role = role;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public TheatreArtCreatedDto getTheatreArt() {
        return theatreArt;
    }

    public UserListDto getInvolvedUser() {
        return involvedUser;
    }

    public SystemRoleDto getRole() {
        return role;
    }

    public TheatreCharacterDto getCharacter() {
        return character;
    }
}