package com.papsukis.CardSimulator.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.papsukis.CardSimulator.models.Decklist;
import com.papsukis.CardSimulator.models.ExtraDeck;
import com.papsukis.CardSimulator.models.MainDeck;
import com.papsukis.CardSimulator.models.SideDeck;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class DecklistDTO {

    @JsonProperty("decklist_id")
    private int id;

    @JsonProperty("main_deck")
    private MainDeck mainDeck;

    @JsonProperty("extra_deck")
    private ExtraDeck extraDeck;

    @JsonProperty("side_deck")
    private SideDeck sideDeck;

    public DecklistDTO(Decklist decklist) {
        this.id=decklist.getId();
        this.extraDeck=decklist.getExtraDeck();
        this.mainDeck=decklist.getMainDeck();
        this.sideDeck=decklist.getSideDeck();
    }

}
