package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos.TheatrePersonelUserDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface TheatrePersonelMapper {
    TheatrePersonel toEntity(TheatrePersonelDto theatrePersonelDto);

    TheatrePersonelDto toDto(TheatrePersonel theatrePersonel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatrePersonel partialUpdate(TheatrePersonelDto theatrePersonelDto, @MappingTarget TheatrePersonel theatrePersonel);

    TheatrePersonel toEntity(TheatrePersonelUserDto theatrePersonelUserDto);

    TheatrePersonelUserDto toDto1(TheatrePersonel theatrePersonel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatrePersonel partialUpdate(TheatrePersonelUserDto theatrePersonelUserDto, @MappingTarget TheatrePersonel theatrePersonel);

    @Mapping(source = "userLastName", target = "user.lastName")
    @Mapping(source = "userFirstName1", target = "user.firstName1")
    @Mapping(source = "userId", target = "user.id")
    TheatrePersonel toEntity(TheatrePersonelListDto theatrePersonelListDto);

    @InheritInverseConfiguration(name = "toEntity")
    TheatrePersonelListDto toDto2(TheatrePersonel theatrePersonel);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TheatrePersonel partialUpdate(TheatrePersonelListDto theatrePersonelListDto, @MappingTarget TheatrePersonel theatrePersonel);
}