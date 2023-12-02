package pl.polsl.musialowski_kamil.theater_manager_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.EventReservation;

import java.util.Optional;
import java.util.Set;

public interface EventReservationsRepository extends JpaRepository<EventReservation, Long> {

    @Query("SELECT DISTINCT e FROM EventReservation e " +
            "JOIN TheatreArt ta ON e.theatreArt.id = ta.id " +
            "JOIN ArtInvolvedPersonel aip ON ta.id = aip.theatreArt.id " +
            "JOIN User u ON aip.involvedUser.id = u.id " +
            "WHERE e.theatreArt.id = ta.id " +
            "AND ta.id = aip.theatreArt.id " +
            "AND aip.involvedUser.id = :userId " +
            "AND e.startDate >= CURRENT_DATE()")
    Optional<Set<EventReservation>> getUserEvents(Long userId);
}