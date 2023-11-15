package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.TheaterArtDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.artInvolvedPersonelDtos.ArtInvolvedPersonelDto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt}
 */
public record TheatreArtDto(Long id, String title, String author1, String author2, String author3,
                            Set<ArtInvolvedPersonelDto> involvedPersonel,
                            Set<TheatreCharacterDto> characters) implements Serializable {
}