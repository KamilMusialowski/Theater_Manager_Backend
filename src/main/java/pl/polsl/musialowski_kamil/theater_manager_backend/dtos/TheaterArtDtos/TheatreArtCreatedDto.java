package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt}
 */
public class TheatreArtCreatedDto implements Serializable {
    private final Long id;
    private final String title;
    private final String author1;
    private final String author2;
    private final String author3;
    private final TheatresListDto theatre;

    public TheatreArtCreatedDto(Long id, String title, String author1, String author2, String author3, TheatresListDto theatre) {
        this.id = id;
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.theatre = theatre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public TheatresListDto getTheatre() {
        return theatre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheatreArtCreatedDto entity = (TheatreArtCreatedDto) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.author1, entity.author1) &&
                Objects.equals(this.author2, entity.author2) &&
                Objects.equals(this.author3, entity.author3) &&
                Objects.equals(this.theatre, entity.theatre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author1, author2, author3, theatre);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "author1 = " + author1 + ", " +
                "author2 = " + author2 + ", " +
                "author3 = " + author3 + ", " +
                "theatre = " + theatre + ")";
    }
}