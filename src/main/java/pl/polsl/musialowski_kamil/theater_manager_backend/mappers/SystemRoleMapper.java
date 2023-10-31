package pl.polsl.musialowski_kamil.theater_manager_backend.mappers;

import org.mapstruct.*;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRoleDtos.SystemRoleDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SystemRoleMapper {
    SystemRole toEntity(SystemRoleDto systemRoleDto);

    SystemRoleDto toDto(SystemRole systemRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SystemRole partialUpdate(SystemRoleDto systemRoleDto, @MappingTarget SystemRole systemRole);

    SystemRole toEntity(pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto.SystemRoleDto systemRoleDto);

    pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto.SystemRoleDto toDto1(SystemRole systemRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SystemRole partialUpdate(pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto.SystemRoleDto systemRoleDto, @MappingTarget SystemRole systemRole);
}