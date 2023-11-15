package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos.HallListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Hall;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TheatreMapper.class})
public interface HallMapper {
    Hall toEntity(HallCreateDto hallCreateDto);

    HallCreateDto toDto(Hall hall);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hall partialUpdate(HallCreateDto hallCreateDto, @MappingTarget Hall hall);

    Hall toEntity(HallDto hallDto);

    HallDto toDto1(Hall hall);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hall partialUpdate(HallDto hallDto, @MappingTarget Hall hall);

    Hall toEntity(HallListDto hallListDto);

    HallListDto toDto2(Hall hall);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hall partialUpdate(HallListDto hallListDto, @MappingTarget Hall hall);
}