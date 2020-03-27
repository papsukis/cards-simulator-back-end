package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="card_prices")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPrices{
	@Id
	@Column(name="card_prices_id",nullable = false,unique = true)
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native_generator")
	private int id;
	@JsonProperty("tcgplayer_price")
	private String tcgplayerPrice;
	@JsonProperty("amazon_price")
	private String amazonPrice;
	@JsonProperty("ebay_price")
	private String ebayPrice;
	@JsonProperty("cardmarket_price")
	private String cardmarketPrice;
	@JsonIgnore
	@OneToOne(mappedBy = "cardPrices")
	private Card card;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CardPrices that = (CardPrices) o;
		return id == that.id &&
				Objects.equals(tcgplayerPrice, that.tcgplayerPrice) &&
				Objects.equals(amazonPrice, that.amazonPrice) &&
				Objects.equals(ebayPrice, that.ebayPrice) &&
				Objects.equals(cardmarketPrice, that.cardmarketPrice) &&
				Objects.equals(card, that.card);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tcgplayerPrice, amazonPrice, ebayPrice, cardmarketPrice, card);
	}
}
