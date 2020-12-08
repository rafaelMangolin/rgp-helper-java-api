package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.TempleConfig;
import com.rpghelper.citymaker.domain.enums.Domain;
import lombok.Data;

import java.util.List;

@Data
public class Temple extends Institution{
    private Domain domain;

    public Temple(TempleConfig templeConfig, List<RaceProportion> raceProportions) {
        super(raceProportions, "Temple of" + templeConfig.getType().name());
        this.domain = templeConfig.getType();
    }


    @Override
    protected String genLabel() {
        return "Temple";
    }
}
