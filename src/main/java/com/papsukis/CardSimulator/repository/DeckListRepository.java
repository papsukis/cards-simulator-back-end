package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.models.Decklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckListRepository extends JpaRepository<Decklist,Integer> {

}
