package com.papsukis.CardSimulator.Decklist.controller;

import com.papsukis.CardSimulator.Decklist.DTO.CardDTO;
import com.papsukis.CardSimulator.Decklist.models.Card;
import com.papsukis.CardSimulator.Decklist.models.SearchQueryResults;
import com.papsukis.CardSimulator.Decklist.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CardController {

    @Autowired
    CardService cardService;
//    @Autowired
//    DeckListService deckListService;



    @GetMapping(value = "/updateAllCards")
    @ResponseBody
    public boolean doStuff() throws IOException {
        return cardService.updateAllCards();
    }

    @GetMapping(value = "/search")
    public SearchQueryResults search(@RequestParam(name = "name", defaultValue="undefined") String name,
                                     @RequestParam(name = "type", defaultValue="undefined") String type,
                                     @RequestParam(name = "desc", defaultValue="undefined") String desc,
                                     @RequestParam(name = "race", defaultValue="undefined") String race,
                                     @RequestParam(name = "archetype", defaultValue="undefined") String archetype,
                                     @RequestParam(name = "atribute", defaultValue="undefined")String atribute,
                                     @RequestParam(name = "maxAtk", defaultValue = "0") String maxAtk,
                                     @RequestParam(name = "minAtk", defaultValue = "0") String minAtk,
                                     @RequestParam(name = "level", defaultValue = "0") String level,
                                     @RequestParam(name = "maxDef", defaultValue = "0") String maxDef,
                                     @RequestParam(name = "minDef", defaultValue = "0") String minDef,
                                     @RequestParam(name="page", defaultValue = "0") String page,
                                     @RequestParam(name="size",defaultValue="100")String size){
        CardDTO card= new CardDTO(name,archetype,race,type,desc,Integer.parseInt(maxAtk),Integer.parseInt(minAtk),Integer.parseInt(maxDef),Integer.parseInt(minDef),Integer.parseInt(level),atribute);

        return cardService.search(card,Integer.parseInt(page),Integer.parseInt(size));
    }


    @GetMapping(value = "/cards")
    @ResponseBody
    public List<Card> findAllCards(){
        return cardService.findAllCards();
    }
}
