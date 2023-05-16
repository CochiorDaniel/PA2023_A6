package com.example.compulsory;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    private List<String> players = Arrays.asList("Daniel", "Bianca", "Gigi");
    @RequestMapping("/home")
    @GetMapping
    public List<String> getPlayers() {
        return players;
    }

}
