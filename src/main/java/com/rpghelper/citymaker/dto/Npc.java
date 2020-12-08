package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.enums.Race;
import lombok.Data;

@Data
public class Npc {
    private String name;
    private Race race;
    private Integer age;
    private String history;

    public Npc(String name, Race race, Integer age, String history) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.history = history;
    }

    public Npc(String name, Race race, Integer age) {
        this.name = name;
        this.race = race;
        this.age = age;
    }
}
