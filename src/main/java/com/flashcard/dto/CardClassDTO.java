package com.flashcard.dto;

import com.flashcard.document.CardClassDocument;

public class CardClassDTO {

    private String id;
    private String name;
    private int numberOfCards;

    public CardClassDTO() {
    }

    public CardClassDTO(CardClassDocument cardClassDocument) {
        this.id = cardClassDocument.getId();
        this.name = cardClassDocument.getName();
        this.numberOfCards = cardClassDocument.getCardDocuments() == null ? 0 : cardClassDocument.getCardDocuments().size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

}
