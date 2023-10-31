package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel;

public interface TheatrePersonelRepository extends JpaRepository<TheatrePersonel, Long> {
}