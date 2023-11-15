package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;

import java.util.Optional;
import java.util.Set;

public interface TheatrePersonelRepository extends JpaRepository<TheatrePersonel, Long> {

    Optional<Set<TheatrePersonel>> findTheatrePersonelsByTheatre_Id(Long theatre_id);
}