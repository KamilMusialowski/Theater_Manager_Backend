package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "Theater.detail", attributeNodes = @NamedAttributeNode("acts"))
@Table(name = "theatre_art")
public class TheatreArt extends BaseEntity{

    @Column(name = "title", length = 80)
    private String title;

    @Column(name = "author_1", length = 80)
    private String author1;

    @Column(name = "author_2", length = 80)
    private String author2;

    @Column(name = "author_3", length = 80)
    private String author3;

    @ManyToOne
    @JoinColumn(name = "inputing_user_id", nullable = false)
    private User inputingUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt", fetch = FetchType.EAGER)
    private Set<EventReservations> eventReservations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt", fetch = FetchType.EAGER)
    private Set<ArtInvolvedPersonel> involvedPersonel = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt", fetch = FetchType.EAGER)
    private Set<Act> acts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt", fetch = FetchType.EAGER)
    private Set<TheatreCharacter> characters = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theatre theatre;

    public TheatreArt() {
    }

    public TheatreArt(Long id, String title, String author1, String author2, String author3, User inputingUser, Set<EventReservations> eventReservations, Set<ArtInvolvedPersonel> involvedPersonel, Set<Act> acts, Set<TheatreCharacter> characters, Theatre theatre) {
        super(id);
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.inputingUser = inputingUser;
        this.eventReservations = eventReservations;
        this.involvedPersonel = involvedPersonel;
        this.acts = acts;
        this.characters = characters;
        this.theatre = theatre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public void setAuthor3(String author3) {
        this.author3 = author3;
    }

    public User getInputingUser() {
        return inputingUser;
    }

    public void setInputingUser(User inputingUser) {
        this.inputingUser = inputingUser;
    }

    public Set<EventReservations> getEventReservations() {
        return eventReservations;
    }

    public void setEventReservations(Set<EventReservations> eventReservations) {
        this.eventReservations = eventReservations;
    }

    public Set<ArtInvolvedPersonel> getInvolvedPersonel() {
        return involvedPersonel;
    }

    public void setInvolvedPersonel(Set<ArtInvolvedPersonel> involvedPersonel) {
        this.involvedPersonel = involvedPersonel;
    }

    public Set<Act> getActs() {
        return acts;
    }

    public void setActs(Set<Act> acts) {
        this.acts = acts;
    }

    public Set<TheatreCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<TheatreCharacter> characters) {
        this.characters = characters;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
