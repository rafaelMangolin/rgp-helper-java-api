package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.enums.ShopType;
import lombok.Data;

import java.util.List;

@Data
public class Shop extends Institution {
    private ShopType type;
    private List<Item> menu;

    public Shop(ShopType type, List<RaceProportion> raceProportions) {
        super(raceProportions, type.name() + " " + String.valueOf(Math.random()));
        this.type = type;
    }

    @Override
    protected String genLabel() {
        return "Shop";
    }
}
