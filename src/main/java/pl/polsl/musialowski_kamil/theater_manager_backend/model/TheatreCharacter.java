package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SexEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class TheatreCharacter extends BaseEntity {

    @Column(name = "name",nullable = false, length = 80)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false, length = 10)
    private SexEnum sex;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "theatreCharacters")
    private Set<Scene> scenes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "theatre_art_id", nullable = false)
    private TheatreArt theatreArt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "character")
    private Set<ArtInvolvedPersonel> personel;
}
