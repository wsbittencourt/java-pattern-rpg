package edu.wagner.javapatternrpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.wagner.javapatternrpg.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
}
