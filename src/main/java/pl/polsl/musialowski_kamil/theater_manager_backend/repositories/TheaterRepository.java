package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.util.Optional;
import java.util.Set;

public interface TheaterRepository extends JpaRepository<Theatre, Long> {

    Optional<Theatre> getTheatreById(Long id);

    @Query("SELECT DISTINCT t FROM Theatre t " +
            "JOIN t.theatrePersonel tp " +
            "WHERE tp.user.id = :userId AND tp.roleEnum = :role")
    Optional<Set<Theatre>> getTheatresForUserIdAndRole(Long userId, SystemRoleEnum role);
}
