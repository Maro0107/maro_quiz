package pl.maro_projekt.maro_quiz.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maro_projekt.maro_quiz.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}