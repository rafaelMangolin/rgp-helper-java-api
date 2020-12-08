package com.rpghelper.citymaker.domain;

import com.rpghelper.citymaker.domain.enums.Race;
import lombok.Data;

@Data
public class RaceConfig {
    private Race type;
    private Rarity rarity;
}
