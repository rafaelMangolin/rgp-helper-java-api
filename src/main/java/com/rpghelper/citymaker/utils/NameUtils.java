package com.rpghelper.citymaker.utils;

import org.apache.tomcat.util.digester.ArrayStack;

import javax.naming.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public  class NameUtils {
    private static List<String> names;
    private static List<String> lastNames;

    static {
        ClassLoader context = Thread.currentThread().getContextClassLoader();
        InputStream nameStream = context.getResourceAsStream("static/name.csv");
        names = Arrays.stream(loadInputStream(nameStream).replace(" ","").split(",")).collect(Collectors.toCollection(ArrayStack::new));
        InputStream lastNameStream = context.getResourceAsStream("static/lastname.csv");
        lastNames = Arrays.stream(loadInputStream(lastNameStream).replace(" ","").split(",")).collect(Collectors.toCollection(ArrayStack::new));
    }

    public static String genRandomName() {
        return RandomUtils.getRandom(names) + " " + RandomUtils.getRandom(lastNames);
    }
    private static String loadInputStream(InputStream inputStream){
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(inputStreamReader).lines().collect(Collectors.joining("\n"));
    }
}
