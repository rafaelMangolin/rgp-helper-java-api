package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.*;
import com.rpghelper.citymaker.domain.enums.ShopType;
import com.rpghelper.citymaker.utils.RandomUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class City implements Serializable {
    private String name;
    private Integer populationSize;
    private String description;
    private String rulerSteriotype;
    private List<RaceProportion> raceProportions;
    private List<Guild> guilds;
    private List<Temple> temples;
    private List<Shop> shops;
    private List<Npc> npcs;


    public City(CityConfig config) {
        this.name = "Enter here the name of your city";
        this.populationSize = RandomUtils.getRandom(config.getMinPopulation(),config.getMaxPopulation());
        this.description = "Enter here the description of your city";
        this.rulerSteriotype = this.genRulerSteriotipe();
        this.raceProportions = this.genRaceProportion(config.getRaces());
        List<RaceProportion> raceProportionsAux = new ArrayList<>(this.raceProportions);
        this.guilds = this.genGuilds(config.getGuilds(),raceProportionsAux);
        this.temples = this.genTemples(config.getTemples(),raceProportionsAux);
        this.shops = this.genShops(config.getShops(),raceProportionsAux);
        this.npcs = this.fillNpcs();
    }

    private List<Npc> fillNpcs() {
        List<Npc> npcs = new ArrayList<>();
        this.guilds.forEach(guild -> npcs.addAll(guild.getNpcList()));
        this.temples.forEach(temple -> npcs.addAll(temple.getNpcList()));
        this.shops.forEach(shop -> npcs.addAll(shop.getNpcList()));
        return npcs;
    }

    private List<Shop> genShops(List<ShopConfig> shopConfigs, List<RaceProportion> raceProportionsAux) {
        Map<ShopType,Integer> shopProportions = new HashMap<>();
        shopConfigs.forEach(shopConfig -> shopProportions.put(shopConfig.getType(),shopConfig.getType().weight));

        List<Shop> shops = new ArrayList<>();
        Integer shopsAmount = RandomUtils.getRandom(Math.floorDiv(this.populationSize,6),Math.floorDiv(this.populationSize,4));
        for (int i = 0; i < shopsAmount; i++) {
            ShopType type = RandomUtils.getRandomWeighted(shopProportions);
            shops.add(new Shop(type,raceProportionsAux));
        }

        return shops;
    }

    private List<Temple> genTemples(List<TempleConfig> temples, List<RaceProportion> raceProportionsAux) {
        return temples.stream()
                .filter(templeConfig-> templeConfig.getGenerate())
                .map(templeConfig -> new Temple(templeConfig, raceProportions))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<Guild> genGuilds(List<GuildConfig> guilds, List<RaceProportion> raceProportions) {
        return guilds.stream()
                .filter(guildConfig-> guildConfig.getGenerate())
                .map(guildConfig -> new Guild(guildConfig, raceProportions))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<RaceProportion> genRaceProportion(List<RaceConfig> races) {
        Map<RaceProportion,Integer> raceProportions = new HashMap<>();
        races.forEach(raceConfig -> raceProportions.put(new RaceProportion(raceConfig.getType()),raceConfig.getRarity().weight));

        for (int i = 0; i < this.populationSize; i++) {
            RandomUtils.getRandomWeighted(raceProportions).increment();
        }

        return (List<RaceProportion>) raceProportions.keySet();
    }

    private String genRulerSteriotipe() {
        List<String> steriotipes = new ArrayList<>();
        steriotipes.add("Respected, fair and just");
        steriotipes.add("Feared tyrant");
        steriotipes.add("Weakling manipulated by others");
        steriotipes.add("Illegitimate ruler, simmering civil war");
        steriotipes.add("Ruled or controlled by a powerful monster");
        steriotipes.add("Mysterious, anonymous cabal");
        steriotipes.add("Contested leadership, open fighting");
        steriotipes.add("Cabal seized power openly 15 Doltish lout");
        steriotipes.add("On deathbed, claimants compete for power");
        steriotipes.add("I ron-willed but respected");
        steriotipes.add("Religious leader");

        return RandomUtils.getRandom(steriotipes);
    }

}
