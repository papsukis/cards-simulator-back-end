package com.papsukis.CardSimulator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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


}
