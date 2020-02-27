package com.papsukis.CardSimulator.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Image {

    private String fullPath;
    private String imageName;
    private String extension;


}
