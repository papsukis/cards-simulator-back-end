package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.CardSetsItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardSetsRepository extends JpaRepository<CardSetsItem,Integer> {
}
