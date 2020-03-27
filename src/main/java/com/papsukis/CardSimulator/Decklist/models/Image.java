package com.papsukis.CardSimulator.Decklist.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Image {

    private String fullPath;
    private String imageName;
    private String extension;


}
