package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.models.Decklist;
import com.papsukis.CardSimulator.Login.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckListRepository extends JpaRepository<Decklist,Integer> {

    List<Decklist> findByUser(User user);
}
