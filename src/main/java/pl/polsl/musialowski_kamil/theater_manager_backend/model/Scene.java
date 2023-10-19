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
    @JoinColumn(name = "act")
    private Act act;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "characters_to_scenes", joinColumns = @JoinColumn(name = "scene_id"),
    inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<TheatreCharacter> theatreCharacters = new HashSet<>();
}
