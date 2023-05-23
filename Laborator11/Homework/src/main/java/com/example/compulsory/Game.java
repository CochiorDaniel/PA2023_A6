package com.example.compulsory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    private int id;
    private String name;
    private Player player1, player2;

    Game(@JsonProperty("id")int id, @JsonProperty("name")String name,@JsonProperty("player1") Player player1, @JsonProperty("player2") Player player2) {
        this.id = id;
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
    }

    Game(){
        this.id = 0;
        this.name = "JOC";
        this.player1 = new Player("Player1", 0);
        this.player2 = new Player("Player2", 1);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
