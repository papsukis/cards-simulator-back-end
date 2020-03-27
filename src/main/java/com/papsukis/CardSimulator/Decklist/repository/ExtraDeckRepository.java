package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.ExtraDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraDeckRepository extends JpaRepository<ExtraDeck, Integer> {
}
