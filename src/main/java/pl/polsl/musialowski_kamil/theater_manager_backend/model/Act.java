package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acts")
public class Act extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "title", length = 80)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theatre_art_id", nullable = false)
    private TheatreArt theatreArt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "act", fetch = FetchType.EAGER)
    private Set<Scene> scenes = new HashSet<>();

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

    public TheatreArt getTheatreArt() {
        return theatreArt;
    }

    public void setTheatreArt(TheatreArt theatreArt) {
        this.theatreArt = theatreArt;
    }

    public Set<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(Set<Scene> scenes) {
        this.scenes = scenes;
    }
}
