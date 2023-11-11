package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Act}
 */
public class ActDto implements Serializable {
    private Integer number;
    private String title;
    private Set<SceneDto> scenes;

    public ActDto() {
    }

    public ActDto(Integer number, String title, Set<SceneDto> scenes) {
        this.number = number;
        this.title = title;
        this.scenes = scenes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SceneDto> getScenes() {
        return scenes;
    }

    public void setScenes(Set<SceneDto> scenes) {
        this.scenes = scenes;
    }
}