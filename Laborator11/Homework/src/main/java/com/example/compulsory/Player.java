package com.example.compulsory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int id;
    Player(@JsonProperty("name") String name,@JsonProperty("id") int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
