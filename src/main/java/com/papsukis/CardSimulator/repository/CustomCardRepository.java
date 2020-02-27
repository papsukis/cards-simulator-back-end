package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.DTO.CardDTO;
import com.papsukis.CardSimulator.models.Card;

import java.util.List;

public interface CustomCardRepository {

    List<Card> search(CardDTO card);
}
