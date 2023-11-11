package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SexEnum;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreCharacter}
 */
public class TheatreCharacterDto implements Serializable {
    private String name;
    private SexEnum sex;

    public TheatreCharacterDto() {
    }

    public TheatreCharacterDto(String name, SexEnum sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}