package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.CardPrices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardPricesRepository extends JpaRepository<CardPrices,Integer> {
}
