package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.enums.Race;
import lombok.Data;

@Data
public class RaceProportion {
    private Race race;
    private Integer population;

    public RaceProportion(Race type) {
        this.race = type;
    }

    public RaceProportion() {}

    public void increment() {
        if(this.population == null){
            this.population=1;
        }else{
            this.population++;
        }
    }

    public void decrement() {
        if(this.population != null && this.population != 0){
            this.population--;
        }
    }
}
