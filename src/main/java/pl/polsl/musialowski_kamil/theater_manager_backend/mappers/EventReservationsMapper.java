package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservation;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {HallMapper.class, TheatreArtMapper.class, UserMapper.class})
public interface EventReservationsMapper {
    EventReservation toEntity(EventReservationsDto eventReservationsDto);

    EventReservationsDto toDto(EventReservation eventReservation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventReservation partialUpdate(EventReservationsDto eventReservationsDto, @MappingTarget EventReservation eventReservation);

    EventReservation toEntity(EventReservationsListDto eventReservationsListDto);

    EventReservationsListDto toDto1(EventReservation eventReservation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventReservation partialUpdate(EventReservationsListDto eventReservationsListDto, @MappingTarget EventReservation eventReservation);
}