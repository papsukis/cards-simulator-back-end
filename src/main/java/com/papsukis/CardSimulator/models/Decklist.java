package com.papsukis.CardSimulator.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Decklist {

    @Id
    @Column(name="decklist_id")
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private int Id;
    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private MainDeck mainDeck;
    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private ExtraDeck extraDeck;
    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private SideDeck sideDeck;

    public Decklist() {
        this.mainDeck=new MainDeck();
        this.extraDeck=new ExtraDeck();
        this.sideDeck=new SideDeck();
    }
}
