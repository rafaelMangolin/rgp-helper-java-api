package com.rpghelper.citymaker.domain;

import com.rpghelper.citymaker.domain.enums.GuildType;
import lombok.Data;

@Data
public class GuildConfig {
    private GuildType type;
    private Boolean generate;
}
