package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.ExtraDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraDeckRepository extends JpaRepository<ExtraDeck, Integer> {
}
