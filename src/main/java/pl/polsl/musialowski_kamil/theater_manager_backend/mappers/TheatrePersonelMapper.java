package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TheatrePersonelMapper {
    TheatrePersonel toEntity(TheatrePersonelDto theatrePersonelDto);

    TheatrePersonelDto toDto(TheatrePersonel theatrePersonel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatrePersonel partialUpdate(TheatrePersonelDto theatrePersonelDto, @MappingTarget TheatrePersonel theatrePersonel);
}