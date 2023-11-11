package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt}
 */
public class TheatreArtCreationDto implements Serializable {
    private String title;
    private String author1;
    private String author2;
    private String author3;
    private Set<ActDto> acts;
    private Set<TheatreCharacterDto> characters;
    private Long theaterId;
    private Long inputingUserId;

    public TheatreArtCreationDto() {
    }

    public TheatreArtCreationDto(String title, String author1, String author2, String author3, Set<ActDto> acts, Set<TheatreCharacterDto> characters, Long theaterId, Long inputingUserId) {
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.acts = acts;
        this.characters = characters;
        this.theaterId = theaterId;
        this.inputingUserId = inputingUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public void setAuthor3(String author3) {
        this.author3 = author3;
    }

    public Set<ActDto> getActs() {
        return acts;
    }

    public void setActs(Set<ActDto> acts) {
        this.acts = acts;
    }

    public Set<TheatreCharacterDto> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<TheatreCharacterDto> characters) {
        this.characters = characters;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public Long getInputingUserId() {
        return inputingUserId;
    }

    public void setInputingUserId(Long inputingUserId) {
        this.inputingUserId = inputingUserId;
    }
}