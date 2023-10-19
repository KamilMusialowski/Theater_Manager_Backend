package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "acts")
public class Act extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "title", length = 80)
    private String title;

    @ManyToOne
    @JoinColumn(name = "theatre_art")
    private TheatreArt theatreArt;

    @ManyToOne
    @JoinColumn(name = "scene")
    private Scene scene;
}
