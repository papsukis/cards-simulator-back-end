package com.papsukis.CardSimulator.Decklist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="card_images")
@Data
public class CardImagesItem extends Image{
	@Id
	@Column(name="card_image_id")
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native_generator")
	private int id;
	@Column(name="card_name")
	private String name;
	@Column(name="card_path")
	private String path;
	@JsonProperty("image_url")
	private String imageUrl;
	@JsonProperty("image_url_small")
	private String imageUrlSmall;



}
