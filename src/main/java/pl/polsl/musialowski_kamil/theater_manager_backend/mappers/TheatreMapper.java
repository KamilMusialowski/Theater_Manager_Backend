package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatreCreateDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TheatreMapper {
    Theatre toEntity(TheatreCreateDto theatreCreateDto);

    TheatreCreateDto toDto1(Theatre theatre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Theatre partialUpdate(TheatreCreateDto theatreCreateDto, @MappingTarget Theatre theatre);

    Theatre toEntity(CreatedTheatreDto theatreCreateDto);

    CreatedTheatreDto toDto2(Theatre theatre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Theatre partialUpdate(CreatedTheatreDto createdTheatreDto, @MappingTarget Theatre theatre);

    Theatre toEntity(TheatresListDto theatresListDto);

    TheatresListDto toTheatresListDto(Theatre theatre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Theatre partialUpdate(TheatresListDto theatresListDto, @MappingTarget Theatre theatre);
}