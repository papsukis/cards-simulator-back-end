package com.papsukis.CardSimulator.Decklist.services.Impl;

import com.papsukis.CardSimulator.Decklist.DTO.DecklistDTO;
import com.papsukis.CardSimulator.Decklist.models.Decklist;
import com.papsukis.CardSimulator.Decklist.repository.DeckListRepository;
import com.papsukis.CardSimulator.Decklist.services.DecklistService;
import com.papsukis.CardSimulator.Login.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DecklistServiceImpl implements DecklistService {
    @Autowired
    DeckListRepository deckListRepository;

    @Override
    @Transactional
    public Decklist saveDecklist(DecklistDTO decklist, User user) {

        Decklist decklistToSave = new Decklist(decklist);
        decklistToSave.setUser(user);

        deckListRepository.save(decklistToSave);

        return decklistToSave;
    }

    @Override
    public List<DecklistDTO> findByUser(User user){
        List<Decklist> decklistFound= deckListRepository.findByUser(user);

        List<DecklistDTO> decklists=new ArrayList<>();
        for(int i=0;i<decklistFound.size();i++){
            decklists.add(new DecklistDTO(decklistFound.get(i)));
        }
        System.out.println("decklists" + decklists.size());
        return decklists;
    }

}
