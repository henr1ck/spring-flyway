package br.edu.ifpi.springflyway.repository;

import br.edu.ifpi.springflyway.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Override
    @Query("select p from Player p " +
            "join fetch p.team " +
            "join fetch p.statistics " +
            "join fetch p.position")
    List<Player> findAll();
}
