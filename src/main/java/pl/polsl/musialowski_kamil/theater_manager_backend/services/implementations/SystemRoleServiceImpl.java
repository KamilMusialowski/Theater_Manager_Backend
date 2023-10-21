package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;

import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRoleDtos.SystemRoleDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.SystemRoleMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.SystemRoleRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.SystemRoleService;

import java.util.Optional;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    private final SystemRoleRepository systemRoleRepository;
    private final SystemRoleMapper systemRoleMapper;

    @Override
    public SystemRole saveRolesForUser(SystemRole systemRole) {
        Optional<SystemRole> systemRoleOptional = systemRoleRepository.findBySystemRole(systemRole.getSystemRole());
        if(systemRoleOptional.isPresent()) {
            return systemRoleOptional.get();
        }
        SystemRole newSystemRole = this.systemRoleRepository
                .save(systemRole);
        return newSystemRole;
    }

    public SystemRoleServiceImpl(SystemRoleRepository systemRoleRepository, SystemRoleMapper systemRoleMapper) {
        this.systemRoleRepository = systemRoleRepository;
        this.systemRoleMapper = systemRoleMapper;
    }
}
