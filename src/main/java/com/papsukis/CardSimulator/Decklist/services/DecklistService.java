package com.papsukis.CardSimulator.Decklist.services;

import com.papsukis.CardSimulator.Decklist.DTO.DecklistDTO;
import com.papsukis.CardSimulator.Decklist.models.Decklist;
import com.papsukis.CardSimulator.Login.Models.User;

import java.util.List;

public interface DecklistService {
    Decklist saveDecklist(DecklistDTO decklist, User byName);

    List<DecklistDTO> findByUser(User user);
}
