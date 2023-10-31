package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.EventTypeDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventType;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventTypeMapper {
    EventType toEntity(EventTypeDto eventTypeDto);

    EventTypeDto toDto(EventType eventType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventType partialUpdate(EventTypeDto eventTypeDto, @MappingTarget EventType eventType);
}