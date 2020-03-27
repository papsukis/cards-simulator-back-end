package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ExtraDeck {

    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    @Column(name="extra_deck_id")
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "extra_deck_card", joinColumns = @JoinColumn(name = "card_id"), inverseJoinColumns = @JoinColumn(name = "extradeck_id"))
    private List<Card> cards;
    @OneToOne(mappedBy = "extraDeck",cascade = CascadeType.ALL)
    @JoinColumn(name="decklist_id")
    @JsonIgnore
    Decklist decklist;


}
