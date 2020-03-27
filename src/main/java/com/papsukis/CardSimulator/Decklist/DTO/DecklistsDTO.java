package com.papsukis.CardSimulator.Decklist.DTO;

import com.papsukis.CardSimulator.Decklist.models.Decklist;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DecklistsDTO {
    List<DecklistDTO> decklists;
}
