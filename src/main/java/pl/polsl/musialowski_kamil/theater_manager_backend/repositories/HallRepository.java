package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Hall;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre;

import java.util.Optional;
import java.util.Set;

public interface HallRepository extends JpaRepository<Hall, Long> {

    Optional<Set<Hall>> findHallsByTheatre(Theatre theatre);
}