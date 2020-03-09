package com.papsukis.CardSimulator.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.papsukis.CardSimulator.DTO.CardDTO;
import com.papsukis.CardSimulator.models.Card;
import com.papsukis.CardSimulator.models.CardImagesItem;
import com.papsukis.CardSimulator.models.CardPrices;
import com.papsukis.CardSimulator.models.CardSetsItem;
import com.papsukis.CardSimulator.repository.*;
import com.papsukis.CardSimulator.services.CardService;
import com.papsukis.CardSimulator.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardsRepository cardsRepository;
    @Autowired
    CardPricesRepository cardPricesRepository;
    @Autowired
    CardImagesRepository cardImagesRepository;
    @Autowired
    CardSetsRepository cardSetsRepository;
    @Autowired
    DeckListRepository deckListRepository;
    @Autowired
    ImageService imageService;

    String basePath = "locahost:10002/";

    private List<Card> cards;
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Card findById(int id) {


        return cardsRepository.findById(id).get();
    }

    @Override
    public List<Card> findFirst50Card(){
        return cardsRepository.findFirst50Cards();

    }

    @Override
    public Card findByName(String name) {
        return null;
    }

    @Override
    public void saveCard() {

    }

    @Override
    public void updateCard(Card card) {

    }

    @Override
    public void deleteCard(int id) {

    }

    @Override
    public List<Card> findAllCards() {
        return (List<Card>) cardsRepository.findAll();
    }

    @Override
    public boolean updateAllCards() throws IOException {


            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> json = restTemplate.exchange("https://db.ygoprodeck.com/api/v5/cardinfo.php", HttpMethod.GET, entity, String.class);
            Card[] response=null;

            List<CardSetsItem> setsItems = new ArrayList<>();
            List<CardImagesItem> imagesItems = new ArrayList<>();
            List<CardPrices> cardPrices = new ArrayList<>();

            try {
                response = mapper.readValue( json.getBody(), Card[].class);
            }catch(Exception e){
                System.out.println(e);
            }

            for (int i = 0; i < response.length ; i++) {

                System.out.println(i + "/" + response.length);
                    if (response[i].getCardSets() != null)
                            {
                                setsItems.addAll(response[i].getCardSets());
                            }
                            //cardSetsRepository.saveAll(response[i].getCardSets());
                    if (response[i].getCardImages() != null)
                    {
                        for(CardImagesItem c : response[i].getCardImages()){
                        c.setImageUrl(
                                imageService.storeImg(
                                        c.getImageUrl(),
                                        formatName(response[i].getName()
                                        )));
                        c.setImageUrlSmall(
                                imageService.storeImg(
                                        c.getImageUrlSmall(),
                                        formatName(response[i].getName()+"_small")
                                    ));
                        c.setName(
                                formatName(
                                        response[i].getName()+".jpg"
                                ));
                        c.setPath(
                                "localhost:10000/"+c.getName()
                                );
                        }
//                        cardImagesRepository.saveAll(response[i].getCardImages());
                    }

                    if (response[i].getCardPrices() != null )
                            cardPrices.add(response[i].getCardPrices());
//                            cardPricesRepository.save(response[i].getCardPrices());



                }
                //cardsRepository.saveAndFlush(response[i]);

        System.out.println(imagesItems.size());

//            cardSetsRepository.saveAll(setsItems);
//            cardImagesRepository.saveAll(imagesItems);
            //cardPricesRepository.saveAll(cardPrices);
            cardsRepository.saveAll(Arrays.asList(response));

            return true;
    }

    @Override
    public List<Card> search(CardDTO card) {

        List<Card> c = cardsRepository.search(card);
        return  c;

    }




    private String formatName(String name)
    {
        return name
            .replace("\"","")
            .replace("/","")
            .replace("?","")
            .replace("!","")
            .replace(" ","_");
    }


}
