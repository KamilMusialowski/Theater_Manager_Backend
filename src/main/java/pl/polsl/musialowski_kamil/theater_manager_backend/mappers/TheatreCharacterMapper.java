package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreCharacterDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreCharacter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TheatreCharacterMapper {
    TheatreCharacter toEntity(TheatreCharacterDto theatreCharacterDto);

    TheatreCharacterDto toDto(TheatreCharacter theatreCharacter);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatreCharacter partialUpdate(TheatreCharacterDto theatreCharacterDto, @MappingTarget TheatreCharacter theatreCharacter);
}