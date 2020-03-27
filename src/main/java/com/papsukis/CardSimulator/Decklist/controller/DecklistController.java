package com.papsukis.CardSimulator.Decklist.controller;


import com.papsukis.CardSimulator.Decklist.DTO.DecklistDTO;
import com.papsukis.CardSimulator.Decklist.DTO.DecklistsDTO;
import com.papsukis.CardSimulator.Decklist.models.Decklist;
import com.papsukis.CardSimulator.Decklist.services.DecklistService;
import com.papsukis.CardSimulator.Login.Security.jwt.JwtUtils;
import com.papsukis.CardSimulator.Login.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DecklistController {

    @Autowired
    DecklistService deckListService;
    @Autowired
    UserService userService;

    @GetMapping(value="getDecklists")
    public DecklistsDTO findByUser(@RequestHeader("Authorization") String authHeader)
    {
        return new DecklistsDTO(deckListService.findByUser(userService.getUserFromJwt(authHeader)));
    }
    @PostMapping(value = "saveDecklist", consumes = "application/json")
    public DecklistDTO addDecklist(@RequestBody DecklistDTO decklist, @RequestHeader("Authorization") String authHeader) {

        DecklistDTO decklistToSave=new DecklistDTO(deckListService.saveDecklist(
                decklist,
                userService.getUserFromJwt(authHeader)));
        return decklistToSave;

    }
}