package com.rpghelper.citymaker.utils;

import com.rpghelper.citymaker.exceptions.InvalidIntervalException;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomUtils {
    public static Integer getRandom(Integer min, Integer max){
        if(min>max) throw new InvalidIntervalException("The interval between ["+min+", "+max+"] is invalid.");
        return (int) Math.round((Math.random() * (max - min)) + min);
    }

    public static <T extends Object> T getRandom(List<T> list) {
        if(list.isEmpty()) return null;
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static <T extends Object> T getRandomWeighted(Map<T,Integer> map) {
        Integer maxWeight = map.values().stream().mapToInt(Integer::intValue).sum();
        maxWeight=RandomUtils.getRandom(0,maxWeight);
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            maxWeight-=entry.getValue();
            if(maxWeight<=0){
                return entry.getKey();
            }
        }
        return null;
    }
}
