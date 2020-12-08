package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.domain.GuildConfig;
import com.rpghelper.citymaker.domain.enums.GuildType;
import com.rpghelper.citymaker.domain.enums.Race;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuildTest {

    private static GuildConfig config;
    private static List<RaceProportion> raceProportions;

    @BeforeAll
    static void beforeAll() {
        config = new GuildConfig();
        config.setGenerate(true);
        config.setType(GuildType.MERCHANT);

        RaceProportion raceProportion = new RaceProportion();
        raceProportion.setRace(Race.DWARF);
        raceProportion.setPopulation(30);

        raceProportions = new ArrayList<>();
        raceProportions.add(raceProportion);
    }

    @Test
    void whenPassAConfigAndRaceProportion_expectGuildNotNull() {
        Guild guild = new Guild(config,raceProportions);

        assertNotNull(guild);
    }

    @Test
    void whenCreateAGuild_expectNameFulfilled() {
        Guild guild = new Guild(config,raceProportions);

        assertNotNull(guild);
        assertThat(guild.getName())
                .isNotNull()
                .isNotBlank();
        assertTrue(guild.getName().contains("Guild"));
    }

    @Test
    void whenCreateAGuild_expectDescriptionToBeNull() {
        Guild guild = new Guild(config,raceProportions);

        assertNotNull(guild);
        assertThat(guild.getDescription())
                .isNull();
    }

    @Test
    void whenCreateAGuild_expectTypeToBeFulfilled() {
        Guild guild = new Guild(config,raceProportions);

        assertNotNull(guild);
        assertThat(guild.getType())
                .isNotNull()
                .isEqualTo(config.getType());
    }

    @Test
    void whenCreateAGuild_expectMembersToBeFulfilled() {
        Guild guild = new Guild(config,raceProportions);

        assertNotNull(guild);
        assertThat(guild.getMembers())
                .isNotNull()
                .isNotEmpty();
        assertEquals(3,guild.getMembers().size());
    }

    @Test
    void whenCreateAGuild_expectNpcListEqualsToMembers() {
        Guild guild = new Guild(config,raceProportions);

        assertEquals(guild.getMembers().size(),guild.getMembers().size());
    }
}