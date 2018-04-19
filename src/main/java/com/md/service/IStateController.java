package com.md.service;

import com.md.model.Player;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IStateController {

    ResponseEntity<Player> addState(Player state);

    ResponseEntity<Player> getPlayerById(long id);

    ResponseEntity<Player> updatePlayerState(long id, Player player);

    ResponseEntity<Collection<Player>> getAll();

    String welcome();

    void deletePlayerStateById(long id);

    void deleteAll();
}
