package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.ArtInvolvedPersonel;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.util.Optional;
import java.util.Set;

public interface ArtInvolvedPersonelRepository extends JpaRepository<ArtInvolvedPersonel, Long> {

    Optional<Set<ArtInvolvedPersonel>> findArtInvolvedPersonelsByInvolvedUserAndRole(User involvedUser, SystemRole systemRole);

    Optional<Set<ArtInvolvedPersonel>> findArtInvolvedPersonelsByTheatreArt(TheatreArt theatreArt);
}