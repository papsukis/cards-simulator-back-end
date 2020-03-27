package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.CardPrices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardPricesRepository extends JpaRepository<CardPrices,Integer> {
}
