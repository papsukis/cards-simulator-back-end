package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.DTO.CardDTO;
import com.papsukis.CardSimulator.models.Card;
import com.papsukis.CardSimulator.models.SearchQueryResults;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomCardRepository {

    SearchQueryResults search(CardDTO card, int firstResult, int maxResult);
}
