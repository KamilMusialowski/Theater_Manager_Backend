package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.AuthenticatedUserDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.RegistryDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {SystemRoleMapper.class, EventReservationsMapper.class})
public interface UserMapper {
    User toEntity(RegistryDto registryDto);

    RegistryDto toRegistryDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(RegistryDto registryDto, @MappingTarget User user);

    User toEntity(UserAllDto userAllDto);

    UserAllDto toUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserAllDto userAllDto, @MappingTarget User user);

    User toEntity(AuthenticatedUserDto authenticatedUserDto);

    AuthenticatedUserDto toAuthenticatedUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(AuthenticatedUserDto authenticatedUserDto, @MappingTarget User user);

    User toEntity(UserListDto userListDto);

    UserListDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserListDto userListDto, @MappingTarget User user);
}