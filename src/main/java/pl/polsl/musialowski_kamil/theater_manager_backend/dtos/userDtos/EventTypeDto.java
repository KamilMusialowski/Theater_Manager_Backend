package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.EventTypeEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.EventType}
 */
public record EventTypeDto(Long id, EventTypeEnum eventType) implements Serializable {
}