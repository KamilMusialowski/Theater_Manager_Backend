package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "theatres_halls")
public class Hall extends BaseEntity {

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "theatre")
    private Theatre theatre;
}
