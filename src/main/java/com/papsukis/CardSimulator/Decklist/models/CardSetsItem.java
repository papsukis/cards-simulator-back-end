package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="card_sets")
public class CardSetsItem{

	/*@Column(name="card_sets_id")
	@Id
	private int id;*/
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native_generator")
	private int id;
	@JsonProperty("set_code")
	private String setCode;
	@JsonProperty("set_rarity")
	private String setRarity;
	@JsonProperty("set_name")
	private String setName;
	@JsonProperty("set_price")
	private String setPrice;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name ="card_id")
	private Card cardID;

	public CardSetsItem() {
	}

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/

	public void setSetCode(String setCode){
		this.setCode = setCode;
	}

	public String getSetCode(){
		return setCode;
	}

	public void setSetRarity(String setRarity){
		this.setRarity = setRarity;
	}

	public String getSetRarity(){
		return setRarity;
	}

	public void setSetName(String setName){
		this.setName = setName;
	}

	public String getSetName(){
		return setName;
	}

	public void setSetPrice(String setPrice){
		this.setPrice = setPrice;
	}

	public String getSetPrice(){
		return setPrice;
	}

	@Override
 	public String toString(){
		return 
			"CardSetsItem{" + 
			"set_code = '" + setCode + '\'' + 
			",set_rarity = '" + setRarity + '\'' + 
			",set_name = '" + setName + '\'' + 
			",set_price = '" + setPrice + '\'' + 
			"}";
		}
}
