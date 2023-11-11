package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Act;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;

import java.util.Optional;
import java.util.Set;

public interface ActRepository extends JpaRepository<Act, Long> {

    Optional<Set<Act>> findActsByTheatreArt(TheatreArt theatreArt);
}