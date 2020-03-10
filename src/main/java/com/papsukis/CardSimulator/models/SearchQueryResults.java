package com.papsukis.CardSimulator.models;

import lombok.Data;

import java.util.List;

@Data
public class SearchQueryResults {
    List<Card> queryResults;
    int resultSize;

}
