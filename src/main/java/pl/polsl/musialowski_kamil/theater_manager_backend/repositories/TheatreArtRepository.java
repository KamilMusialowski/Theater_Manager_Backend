package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatreArt;

import java.util.Optional;

public interface TheatreArtRepository extends JpaRepository<TheatreArt, Long> {

}