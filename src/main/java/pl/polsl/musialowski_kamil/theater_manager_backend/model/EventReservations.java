package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event_reservations")
public class EventReservations extends BaseEntity {

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "theatre_art")
    private TheatreArt theatreArt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_to_events", joinColumns = @JoinColumn (name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();
}
