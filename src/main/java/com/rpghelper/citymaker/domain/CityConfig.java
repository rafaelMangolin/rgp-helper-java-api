package com.rpghelper.citymaker.domain;

import com.rpghelper.citymaker.domain.enums.CityType;
import com.rpghelper.citymaker.domain.enums.Race;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Data
public class CityConfig implements Serializable {

    @Id
    private String id;

    private String hash;
    private CityType type;
    private Integer minPopulation;
    private Integer maxPopulation;
    private List<RaceConfig> races;
    private List<ShopConfig> shops;
    private List<TempleConfig> temples;
    private List<GuildConfig> guilds;

}
