package pl.polsl.musialowski_kamil.theater_manager_backend.model;

import jakarta.persistence.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event_types")
public class EventType extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventTypeEnum eventType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventType")
    private Set<EventReservations> events = new HashSet<>();

    public EventType() {
        this.eventType = EventTypeEnum.NONE;
    }

    public EventType(Long id, EventTypeEnum eventType) {
        super(id);
        this.eventType = eventType;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }
}
