package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "art_involved_personel")
public class ArtInvolvedPersonel extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "theatre_art")
    private TheatreArt theatreArt;

    @ManyToOne
    @JoinColumn(name = "involved_user")
    private User involvedUser;

    @ManyToOne
    @JoinColumn(name = "role")
    private SystemRole role;

    @ManyToOne
    @JoinColumn(name = "character")
    private TheatreCharacter character;
}
