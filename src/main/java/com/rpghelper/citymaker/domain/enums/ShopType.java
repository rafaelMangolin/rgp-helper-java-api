package com.rpghelper.citymaker.domain.enums;

public enum ShopType {
    PAWNSHOP(60),
    MITHY(60),
    HERBSINCENSE(100),
    CARPENTER(100),
    FRUITSVEGETABLES(100),
    WEAVER(100),
    DRIEDMEATS(100),
    JEWELER(60),
    POTTERY(60),
    BAKER(60),
    UNDERTAKER(60),
    MAPMAKER(30),
    BOOKSTORE(30),
    TAILOR(60),
    MONEYLENDER(60),
    ROPEMAKER(60),
    WEAPONSARMOR(60),
    MASON(30),
    CHANDLER(60),
    SCRIBE(30),
    TAVERN(500),
    GENERALSTORE(500),
    MAGICSHOP(10);

    public Integer weight;

    ShopType(Integer weight) {
        this.weight = weight;
    }
}
