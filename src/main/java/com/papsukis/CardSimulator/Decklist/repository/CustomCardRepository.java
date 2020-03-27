package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.DTO.CardDTO;
import com.papsukis.CardSimulator.Decklist.models.SearchQueryResults;

public interface CustomCardRepository {

    SearchQueryResults search(CardDTO card, int firstResult, int maxResult);
}
