package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.CardSetsItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardSetsRepository extends JpaRepository<CardSetsItem,Integer> {
}
