package com.papsukis.CardSimulator.Decklist.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.papsukis.CardSimulator.Decklist.models.Decklist;
import com.papsukis.CardSimulator.Decklist.models.ExtraDeck;
import com.papsukis.CardSimulator.Decklist.models.MainDeck;
import com.papsukis.CardSimulator.Decklist.models.SideDeck;
import lombok.Data;

@Data
public class DecklistDTO {

    @JsonProperty("decklist_id")
    private int id;

    @JsonProperty("mainDeck")
    private MainDeck mainDeck;

    @JsonProperty("extraDeck")
    private ExtraDeck extraDeck;

    @JsonProperty("sideDeck")
    private SideDeck sideDeck;

    public DecklistDTO() {
    }

    public DecklistDTO(Decklist decklist) {
        this.id=decklist.getId();
        this.extraDeck=decklist.getExtraDeck();
        this.mainDeck=decklist.getMainDeck();
        this.sideDeck=decklist.getSideDeck();
    }

}
