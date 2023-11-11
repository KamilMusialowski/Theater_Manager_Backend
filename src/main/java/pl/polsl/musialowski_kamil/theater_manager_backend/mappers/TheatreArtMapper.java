package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreatedDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos.TheatreArtCreationDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TheatreMapper.class})
public interface TheatreArtMapper {
    TheatreArt toEntity(TheatreArtCreationDto theatreArtCreationDto);

    @AfterMapping
    default void linkActs(@MappingTarget TheatreArt theatreArt) {
        theatreArt.getActs().forEach(act -> act.setTheatreArt(theatreArt));
    }

    @AfterMapping
    default void linkCharacters(@MappingTarget TheatreArt theatreArt) {
        theatreArt.getCharacters().forEach(character -> character.setTheatreArt(theatreArt));
    }

    TheatreArtCreationDto toDto(TheatreArt theatreArt);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatreArt partialUpdate(TheatreArtCreationDto theatreArtCreationDto, @MappingTarget TheatreArt theatreArt);

    TheatreArt toEntity(TheatreArtCreatedDto theatreArtCreatedDto);

    TheatreArtCreatedDto toDto1(TheatreArt theatreArt);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatreArt partialUpdate(TheatreArtCreatedDto theatreArtCreatedDto, @MappingTarget TheatreArt theatreArt);
}