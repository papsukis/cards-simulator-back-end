package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.CardImagesItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardImagesRepository extends JpaRepository<CardImagesItem, Integer> {
}
