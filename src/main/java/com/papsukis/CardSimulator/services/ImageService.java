package com.papsukis.CardSimulator.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface ImageService {

    String storeImg(String IMGurl, String name) throws IOException ;

}
