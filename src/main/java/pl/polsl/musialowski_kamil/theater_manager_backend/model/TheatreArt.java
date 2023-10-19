package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
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
    @JoinColumn(name = "app_user")
    private User inputingUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt")
    private Set<EventReservations> eventReservations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt")
    private Set<ArtInvolvedPersonel> involvedUsers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt")
    private Set<Act> acts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreArt")
    private Set<TheatreCharacter> characters = new HashSet<>();

    public TheatreArt() {
    }

    public TheatreArt(Long id,
                      String title,
                      String author1,
                      String author2,
                      String author3) {
        super(id);
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
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
}
