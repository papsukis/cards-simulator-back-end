package com.papsukis.CardSimulator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="banlist_info")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BanlistInfo {

    @Id
    @Column(name="banlist_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native_generator")
    private int id;
    @JsonProperty("ban_tcg")
    @Column(name="ban_tcg")
    String banTCG;
    @JsonProperty("ban_ocg")
    @Column(name="ban_ocg")
    String banOCG;
    @JsonProperty("ban_goat")
    @Column(name="ban_goat")
    String banGoat;
    @JsonIgnore
    @OneToOne(mappedBy = "cardPrices")
    private Card card;
}
