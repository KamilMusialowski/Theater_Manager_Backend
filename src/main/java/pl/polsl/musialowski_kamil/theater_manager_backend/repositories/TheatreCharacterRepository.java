package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreCharacter;

import java.util.Optional;

public interface TheatreCharacterRepository extends JpaRepository<TheatreCharacter, Long> {

    Optional<TheatreCharacter> getTheatreCharacterByNameAndTheatreArt(String name, TheatreArt theatreArt);
}