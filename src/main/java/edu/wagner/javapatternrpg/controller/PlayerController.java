package edu.wagner.javapatternrpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wagner.javapatternrpg.service.AttackService;
import edu.wagner.javapatternrpg.service.PlayerService;
import edu.wagner.javapatternrpg.model.Player;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private AttackService attackService;


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }
    
    @PostMapping("/{attackerId}/attack/{targetId}")
    public ResponseEntity<String> attackPlayer(
        @PathVariable Long attackerId,
        @PathVariable Long targetId
    ) {
        return ResponseEntity.ok(attackService.attackPlayer(attackerId, targetId));
    }
}