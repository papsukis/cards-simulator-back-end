package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.SideDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideDeckRepository extends JpaRepository<SideDeck,Integer> {
}
