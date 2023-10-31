package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.EventReservationsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservations;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {EventTypeMapper.class})
public interface EventReservationsMapper {
    EventReservations toEntity(EventReservationsDto eventReservationsDto);

    EventReservationsDto toDto(EventReservations eventReservations);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventReservations partialUpdate(EventReservationsDto eventReservationsDto, @MappingTarget EventReservations eventReservations);
}