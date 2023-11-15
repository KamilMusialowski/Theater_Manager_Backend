package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Scenes")
public class Scene extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "act_id", nullable = false)
    private Act act;

    @ManyToMany
    @JoinTable(name = "characters_to_scenes", joinColumns = @JoinColumn(name = "scene_id"),
    inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<TheatreCharacter> theatreCharacters = new HashSet<>();

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Set<TheatreCharacter> getTheatreCharacters() {
        return theatreCharacters;
    }

    public void setTheatreCharacters(Set<TheatreCharacter> theatreCharacters) {
        this.theatreCharacters = theatreCharacters;
    }
}
