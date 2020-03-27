package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Card, Integer>,CustomCardRepository {

    @Query(value="SELECT * FROM `cards` LIMIT 50",nativeQuery = true)
    List<Card> findFirst50Cards();
}
