package com.rpghelper.citymaker.domain;

import com.rpghelper.citymaker.domain.enums.Domain;
import lombok.Data;

@Data
public class TempleConfig {
    private Domain type;
    private Boolean generate;
}
