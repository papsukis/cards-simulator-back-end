package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.CardImagesItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardImagesRepository extends JpaRepository<CardImagesItem, Integer> {
}
