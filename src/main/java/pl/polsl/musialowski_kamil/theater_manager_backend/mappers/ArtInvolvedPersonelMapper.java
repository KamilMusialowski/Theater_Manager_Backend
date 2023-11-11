package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.artInvolvedPersonelDtos.ArtInvolvedPersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.ArtInvolvedPersonel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TheatreArtMapper.class, UserMapper.class, SystemRoleMapper.class, TheatreCharacterMapper.class})
public interface ArtInvolvedPersonelMapper {
    ArtInvolvedPersonel toEntity(ArtInvolvedPersonelDto artInvolvedPersonelDto);

    ArtInvolvedPersonelDto toDto(ArtInvolvedPersonel artInvolvedPersonel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ArtInvolvedPersonel partialUpdate(ArtInvolvedPersonelDto artInvolvedPersonelDto, @MappingTarget ArtInvolvedPersonel artInvolvedPersonel);
}