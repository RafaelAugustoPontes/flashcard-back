package com.flashcard.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class CardDocument {

    @Id
    private String id;
    private String term;
    private String definition;
    private LocalDateTime insertDateTime;
    @DBRef
    private CardClassDocument cardClassDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public CardClassDocument getCardClassDocument() {
        return cardClassDocument;
    }

    public void setCardClassDocument(CardClassDocument cardClassDocument) {
        this.cardClassDocument = cardClassDocument;
    }
}
