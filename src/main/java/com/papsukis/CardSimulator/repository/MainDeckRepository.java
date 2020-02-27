package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.MainDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDeckRepository extends JpaRepository<MainDeck, Integer> {
}
