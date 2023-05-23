package com.example.compulsory;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class PlayerController {
    private List<Player> players = new ArrayList<>();
    @GetMapping
    public List<Player> getPlayers() {
        return players;
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestParam String name) {
        players.add(new Player(name, players.size()));
        return new ResponseEntity<>("Player added successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayer(@RequestParam int id) {
        players.removeIf(player -> player.getId() == id);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updatePlayer(@RequestParam int id, @RequestParam String name) {
        players.get(id).setName(name);
        return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
    }
}
