package com.rpghelper.citymaker.domain;

import com.rpghelper.citymaker.domain.enums.ShopType;
import lombok.Data;

@Data
public class ShopConfig {
    private ShopType type;
    private Boolean generate;
}
