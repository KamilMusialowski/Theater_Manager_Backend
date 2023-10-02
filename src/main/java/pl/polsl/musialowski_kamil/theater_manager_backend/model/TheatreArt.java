package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "theatre_arts")
public class TheatreArt extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "author_1")
    private String author1;

    @Column(name = "author_2")
    private String author2;

    @Column(name = "author_3")
    private String author3;

//    private List<pl.polsl.musialowski_kamil.theater_manager_backend.model.Director>
//            directorsList;
//
//    private List<pl.polsl.musialowski_kamil.theater_manager_backend.model.Character>
//            charactersList;

    //private List<Act> actsList;

    //private List<Play> playsList;


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
