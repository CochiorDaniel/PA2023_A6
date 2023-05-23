package com.example.compulsory;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private List<Game> games = new ArrayList<>();

    @GetMapping
    public List<Game> getPlayers() {
        return games;
    }

}
