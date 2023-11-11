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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theatre_art_id", nullable = false)
    private TheatreArt theatreArt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "character", fetch = FetchType.EAGER)
    private Set<ArtInvolvedPersonel> personel;

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

    public Set<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(Set<Scene> scenes) {
        this.scenes = scenes;
    }

    public TheatreArt getTheatreArt() {
        return theatreArt;
    }

    public void setTheatreArt(TheatreArt theatreArt) {
        this.theatreArt = theatreArt;
    }

    public Set<ArtInvolvedPersonel> getPersonel() {
        return personel;
    }

    public void setPersonel(Set<ArtInvolvedPersonel> personel) {
        this.personel = personel;
    }
}
