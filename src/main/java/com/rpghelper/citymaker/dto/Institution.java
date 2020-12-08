package com.rpghelper.citymaker.dto;

import com.rpghelper.citymaker.utils.RandomUtils;
import com.rpghelper.citymaker.utils.NameUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public abstract class Institution {
    private String name;
    private String description;
    private List<NpcOccupation> members;

    public Institution(List<RaceProportion> raceProportions, String name) {
        this.name = name;
        this.members = genMembers(raceProportions);
    }

    public Institution() {}

    private List<NpcOccupation> genMembers(List<RaceProportion> raceProportions) {
        List<NpcOccupation> members = new ArrayList<>();
        String label = genLabel();

        RaceProportion rp = RandomUtils.getRandom(raceProportions);
        rp.decrement();
        Npc chief = new Npc(
                NameUtils.genRandomName(),
                rp.getRace(),
                RandomUtils.getRandom(30,60));
        members.add(new NpcOccupation(chief,label+" Leader"));

        rp = RandomUtils.getRandom(raceProportions);
        Npc member = new Npc(
                NameUtils.genRandomName(),
                rp.getRace(),
                RandomUtils.getRandom(20,40));
        members.add(new NpcOccupation(member,label+" Member"));

        rp = RandomUtils.getRandom(raceProportions);
        member = new Npc(
                NameUtils.genRandomName(),
                rp.getRace(),
                RandomUtils.getRandom(20,40));
        members.add(new NpcOccupation(member,label+" Member"));

        return members;
    }


    public List<Npc> getNpcList(){
        return this.members.stream().map(NpcOccupation::getNpc).collect(Collectors.toList());
    }


    protected abstract String genLabel();
}
