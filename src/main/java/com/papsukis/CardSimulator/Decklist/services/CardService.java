package com.papsukis.CardSimulator.Decklist.services;

import com.papsukis.CardSimulator.Decklist.DTO.CardDTO;
import com.papsukis.CardSimulator.Decklist.models.Card;
import com.papsukis.CardSimulator.Decklist.models.SearchQueryResults;

import java.io.IOException;
import java.util.List;

public interface CardService {

    Card findById(int id);

    List<Card> findFirst50Card();

    Card findByName(String name);
    void saveCard();
    void updateCard(Card card);
    void deleteCard(int id);
    List<Card> findAllCards();
    boolean updateAllCards() throws IOException;
    SearchQueryResults search(CardDTO card, int page, int size);

}
