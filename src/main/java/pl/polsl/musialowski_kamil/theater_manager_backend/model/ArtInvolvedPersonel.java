package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "art_involved_personel")
public class ArtInvolvedPersonel extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "theatre_art_id", nullable = false)
    private TheatreArt theatreArt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User involvedUser;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private SystemRole role;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private TheatreCharacter character;

    public ArtInvolvedPersonel() {
    }

    public ArtInvolvedPersonel(Long id, TheatreArt theatreArt, User involvedUser, SystemRole role, TheatreCharacter character) {
        super(id);
        this.theatreArt = theatreArt;
        this.involvedUser = involvedUser;
        this.role = role;
        this.character = character;
    }

    public ArtInvolvedPersonel(TheatreArt theatreArt, User involvedUser, SystemRole role, TheatreCharacter character) {
        this.theatreArt = theatreArt;
        this.involvedUser = involvedUser;
        this.role = role;
        this.character = character;
    }

    public TheatreArt getTheatreArt() {
        return theatreArt;
    }

    public void setTheatreArt(TheatreArt theatreArt) {
        this.theatreArt = theatreArt;
    }

    public User getInvolvedUser() {
        return involvedUser;
    }

    public void setInvolvedUser(User involvedUser) {
        this.involvedUser = involvedUser;
    }

    public SystemRole getRole() {
        return role;
    }

    public void setRole(SystemRole role) {
        this.role = role;
    }

    public TheatreCharacter getCharacter() {
        return character;
    }

    public void setCharacter(TheatreCharacter character) {
        this.character = character;
    }
}
