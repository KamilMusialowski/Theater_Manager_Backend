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

    @ManyToOne
    @JoinColumn(name = "theatre_art_id", nullable = false)
    private TheatreArt theatreArt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "act")
    private Set<Scene> scenes = new HashSet<>();
}
