package br.edu.ifpi.springflyway.controller;

import br.edu.ifpi.springflyway.domain.Team;
import br.edu.ifpi.springflyway.domain.Tournament;
import br.edu.ifpi.springflyway.repository.TeamRepository;
import br.edu.ifpi.springflyway.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final TournamentRepository tournamentRepository;

    @GetMapping
    public ResponseEntity<List<Team>> listAll(){
        return ResponseEntity.ok(teamRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Team> find(@PathVariable Long id){
        return ResponseEntity.ok(findById(id));
    }

    @PostMapping
    public ResponseEntity<Team> save(@RequestBody Team team){
        List<Tournament> tournaments = new ArrayList<>();
        team.getTournaments().forEach((t) -> {
            Tournament tournament = tournamentRepository.findById(t.getId()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
            );
            tournaments.add(tournament);
        });
        team.setTournaments(tournaments);

        Team teamSaved = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamSaved);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@PathVariable Long id, @RequestBody Team team){
        Team teamFound = teamRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );

        BeanUtils.copyProperties(team, teamFound, "id");
        teamRepository.save(teamFound);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        teamRepository.delete(findById(id));
        return ResponseEntity.noContent().build();
    }

    private Team findById(Long id){
        return teamRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
    }
}
