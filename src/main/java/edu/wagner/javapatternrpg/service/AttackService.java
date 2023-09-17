package edu.wagner.javapatternrpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wagner.javapatternrpg.repository.PlayerRepository;
import edu.wagner.javapatternrpg.model.Player;

@Service
public class AttackService {
    @Autowired
    private PlayerRepository playerRepository;

    public String attackPlayer(Long attackerId, Long targetId) {
        Player attacker = playerRepository.findById(attackerId)
            .orElseThrow(() -> new NotFoundException("Attacker not found"));
        Player target = playerRepository.findById(targetId)
            .orElseThrow(() -> new NotFoundException("Target not found"));
        
        int newHealth = target.getHealth() - attacker.getDamage();
        if (newHealth <= 0) {
            return target.getName() + " perdeu!";
        }

        target.setHealth(newHealth);
        playerRepository.save(target);

        return "Vida atual de " + target.getName() + ": " + newHealth;
    }
}
