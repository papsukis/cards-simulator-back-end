package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="cards")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card{


	@Id
	@Column (name="card_id")
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native_generator")
	private int id;

	@JsonProperty("card_archetype")
	private String archetype;

	@Column(name="card_race")
	private String race;

	@JsonProperty("card_sets")
	@ManyToMany(fetch= FetchType.EAGER,
			cascade={ CascadeType.ALL})
	@JoinTable(name = "card_sets_cards",
			joinColumns = @JoinColumn(name = "card_id"),
			inverseJoinColumns = @JoinColumn(name = "card_sets_id"))
	private List<CardSetsItem> cardSets;

	@JsonProperty("card_prices")
	@OneToOne(cascade={ CascadeType.ALL})
	@JsonIgnore
	private CardPrices cardPrices;


	@Column(name="card_name")
	private String name;

	@JsonProperty("card_images")
	@OneToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.ALL,
			orphanRemoval = true)
	@JoinColumn(name = "card_id")
	private List<CardImagesItem> cardImages = new ArrayList<>();

	@Column(name="card_type")
	private String type;

	@Column(name="card_desc",length = 2000)
	private String desc;

	@JsonProperty("atk")
	private int atk;

	@JsonProperty("def")
	private int def;

	@JsonProperty("level")
	private int level;

	@JsonProperty("attribute")
	private String atribute;

	@JsonProperty("banlist_info")
	@OneToOne(cascade={ CascadeType.ALL})
	@JsonIgnore
	private BanlistInfo banlistInfo;

//	@ManyToMany(mappedBy = "cards")
//	@JsonIgnore
//	private List<ExtraDeck> extraDeck;
//
//	@ManyToMany(mappedBy = "cards")
//	@JsonIgnore
//	private List<MainDeck> mainDeck;
//
//	@ManyToMany(mappedBy = "cards")
//	@JsonIgnore
//	private List<SideDeck> sideDeck;


	public Card(){

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return id == card.id &&
				atk == card.atk &&
				def == card.def &&
				level == card.level &&
				Objects.equals(archetype, card.archetype) &&
				Objects.equals(race, card.race) &&
				Objects.equals(cardSets, card.cardSets) &&
				Objects.equals(cardPrices, card.cardPrices) &&
				Objects.equals(name, card.name) &&
				Objects.equals(cardImages, card.cardImages) &&
				Objects.equals(type, card.type) &&
				Objects.equals(desc, card.desc) &&
				Objects.equals(atribute, card.atribute) &&
				Objects.equals(banlistInfo, card.banlistInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, archetype, race, cardSets, cardPrices, name, cardImages, type, desc, atk, def, level, atribute, banlistInfo);
	}
}