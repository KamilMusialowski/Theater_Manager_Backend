package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.util.Optional;

public interface SystemRoleRepository extends JpaRepository<SystemRole, Long> {

    Optional<SystemRole> findBySystemRole(SystemRoleEnum systemRoleEnum);
}
