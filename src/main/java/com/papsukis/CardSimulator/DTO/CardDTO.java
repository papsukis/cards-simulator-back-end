package com.papsukis.CardSimulator.DTO;

import lombok.Data;

@Data
public class CardDTO {

    private String name;
    private String archetype;
    private String race;
    private String type;
    private String desc;
    private int maxAtk;
    private int minAtk;
    private int maxDef;
    private int minDef;
    private int level;
    private String atribute;

    public CardDTO(String name,
                   String archetype,
                   String race,
                   String type,
                   String desc,
                   int maxAtk,
                   int minAtk,
                   int maxDef,
                   int minDef,
                   int level,
                   String atribute) {
        this.name = name;
        this.archetype = archetype;
        this.race = race;
        this.type = type;
        this.desc = desc;
        this.maxAtk = maxAtk;
        this.minAtk = minAtk;
        this.maxDef = maxDef;
        this.minDef = minDef;
        this.level = level;
        this.atribute = atribute;
    }

    public CardDTO() {
    }

}

