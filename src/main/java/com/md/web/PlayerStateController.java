package com.md.web;

import com.md.model.Player;
import com.md.service.IStateController;
import com.md.service.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/md")
public class PlayerStateController implements IStateController {

    @Autowired
    private IStateRepository repository;

    @Override
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Inmobile service works properly";
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Player>> getAll() {

        Collection<Player> response = repository.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Player> getPlayerById(@PathVariable long id) {

        Player response = repository.findOne(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Player> updatePlayerState(@PathVariable("id") long id, @RequestBody Player player) {

        Player currentPlayer = repository.findOne(id);
        currentPlayer.setState(player.getState());

        Player response = repository.save(currentPlayer);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlayerStateById(@PathVariable long id) {
        repository.delete(id);
    }

    @Override
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Player> addState(@RequestBody Player player) {

        Player currentPlayer = new Player.Builder()
                .state(player.getState())
                .build();

//        return new ResponseEntity<>(repository.save(currentPlayer), HttpStatus.CREATED);
        return new ResponseEntity<>(currentPlayer, HttpStatus.CREATED);
    }
}
