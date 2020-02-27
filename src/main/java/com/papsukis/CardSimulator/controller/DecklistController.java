package com.papsukis.CardSimulator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DecklistController {

//    @Autowired
//    DeckListService deckListService;
//
//    @GetMapping("decklist/{id}")
//    public DecklistDTO getDecklist(@PathVariable int id){
//        return new DecklistDTO(deckListService.getDecklist(id));
//    }
//    @PostMapping("addDecklist")
//    public boolean addDecklist(DecklistDTO decklist)
//    {
//        System.out.println("decklistDTO : " + decklist.toString());
//        return false;
//    }
}
