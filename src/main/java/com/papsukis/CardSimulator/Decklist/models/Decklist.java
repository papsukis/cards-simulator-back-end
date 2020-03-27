package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.papsukis.CardSimulator.Decklist.DTO.DecklistDTO;
import com.papsukis.CardSimulator.Login.Models.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Decklist {

    @Id
    @Column(name="decklist_id")
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private int Id;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private MainDeck mainDeck;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private ExtraDeck extraDeck;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private SideDeck sideDeck;
    @ManyToOne
    User user;

    public Decklist() {
        this.mainDeck=new MainDeck();
        this.extraDeck=new ExtraDeck();
        this.sideDeck=new SideDeck();
    }
    public Decklist(DecklistDTO decklist){
        this.Id=decklist.getId();
        this.extraDeck=decklist.getExtraDeck();
        this.mainDeck=decklist.getMainDeck();
        this.sideDeck=decklist.getSideDeck();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decklist decklist = (Decklist) o;
        return Objects.equals(mainDeck, decklist.mainDeck) &&
                Objects.equals(extraDeck, decklist.extraDeck) &&
                Objects.equals(sideDeck, decklist.sideDeck) &&
                Objects.equals(user, decklist.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainDeck, extraDeck, sideDeck, user);
    }
}
