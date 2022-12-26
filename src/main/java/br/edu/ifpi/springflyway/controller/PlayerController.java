package br.edu.ifpi.springflyway.controller;

import br.edu.ifpi.springflyway.domain.Player;
import br.edu.ifpi.springflyway.domain.Team;
import br.edu.ifpi.springflyway.repository.PlayerRepository;
import br.edu.ifpi.springflyway.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @GetMapping
    public ResponseEntity<List<Player>> listAll(){
        return ResponseEntity.ok(playerRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Player> find(@PathVariable Long id){
        return ResponseEntity.ok(findById(id));
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        Long teamId = player.getTeam().getId();
        Team teamFound = teamRepository.findById(teamId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        player.setTeam(teamFound);
        Player playerSaved = playerRepository.save(player);

        return ResponseEntity.status(HttpStatus.CREATED).body(playerSaved);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@PathVariable Long id, @RequestBody Player player){
        Player playerFound = playerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        BeanUtils.copyProperties(player, playerFound, "id");
        playerRepository.save(playerFound);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        playerRepository.delete(findById(id));
        return ResponseEntity.noContent().build();
    }

    private Player findById(Long id){
        return playerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
    }
}
