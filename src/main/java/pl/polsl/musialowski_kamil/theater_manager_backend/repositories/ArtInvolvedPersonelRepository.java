package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.ArtInvolvedPersonel;

public interface ArtInvolvedPersonelRepository extends JpaRepository<ArtInvolvedPersonel, Long> {
}