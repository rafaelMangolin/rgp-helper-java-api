package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.GuildConfig;
import com.rpghelper.citymaker.domain.enums.GuildType;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Guild extends Institution {
    private GuildType type;

    public Guild(){}

    public Guild(GuildConfig guildConfig, List<RaceProportion> raceProportions) {
        super(raceProportions,guildConfig.getType().toString()+" Guild");
        this.type = guildConfig.getType();
    }

    @Override
    protected String genLabel() {
        return "Guild";
    }
}
