package com.rpghelper.citymaker.domain;

public enum Rarity {
    PREDOMINANT(60),VERYCOMMON(25),COMMON(10),FEW(4),ALMOSNONEXISTENT(1),NONEXISTENT(0);

    public Integer weight;

    Rarity(int weight) {
        this.weight = weight;
    }
}
