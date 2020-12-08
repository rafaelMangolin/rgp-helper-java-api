package com.rpghelper.citymaker.dto;

import lombok.Data;

@Data
public class NpcOccupation {
    private String occupation;
    private Npc npc;

    public NpcOccupation(Npc npc, String occupation) {
        this.npc = npc;
        this.occupation = occupation;
    }
}
