package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Scene}
 */
public class SceneDto implements Serializable {
    private  Integer number;
    private  Set<TheatreCharacterDto> theatreCharacters;


    public SceneDto() {
    }

    public SceneDto(Integer number, Set<TheatreCharacterDto> theatreCharacters) {
        this.number = number;
        this.theatreCharacters = theatreCharacters;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<TheatreCharacterDto> getTheatreCharacters() {
        return theatreCharacters;
    }

    public void setTheatreCharacters(Set<TheatreCharacterDto> theatreCharacters) {
        this.theatreCharacters = theatreCharacters;
    }
}