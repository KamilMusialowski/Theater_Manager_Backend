package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event_reservations")
public class EventReservation extends BaseEntity {

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventTypeEnum eventType;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "theatre_art_id")
    private TheatreArt theatreArt;

    @ManyToMany(mappedBy = "events")
    private Set<User> users = new HashSet<>();

    public EventReservation() {
    }

    public EventReservation(Long id, LocalDateTime startDate, LocalDateTime endDate, EventTypeEnum eventType, Hall hall, TheatreArt theatreArt, Set<User> users) {
        super(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.hall = hall;
        this.theatreArt = theatreArt;
        this.users = users;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public TheatreArt getTheatreArt() {
        return theatreArt;
    }

    public void setTheatreArt(TheatreArt theatreArt) {
        this.theatreArt = theatreArt;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
