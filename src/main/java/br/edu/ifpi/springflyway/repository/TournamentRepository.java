package br.edu.ifpi.springflyway.repository;

import br.edu.ifpi.springflyway.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
