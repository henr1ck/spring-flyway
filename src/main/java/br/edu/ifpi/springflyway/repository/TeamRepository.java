package br.edu.ifpi.springflyway.repository;

import br.edu.ifpi.springflyway.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Override
    @Query("from Team t join fetch t.tournaments")
    List<Team> findAll();
}
