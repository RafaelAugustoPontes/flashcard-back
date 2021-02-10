package com.flashcard.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class CardClassDocument {

    @Id
    private String id;
    private String name;
    @DBRef
    private List<CardDocument> cardDocuments = new ArrayList<>();

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

    public List<CardDocument> getCardDocuments() {
        return cardDocuments;
    }

    public void addCard(CardDocument cardDocument) {
        this.cardDocuments.add(cardDocument);
    }
}
