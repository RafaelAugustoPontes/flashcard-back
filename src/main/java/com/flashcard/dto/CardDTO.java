package com.flashcard.dto;

import com.flashcard.document.CardDocument;

import java.time.LocalDateTime;

public class CardDTO {

    private String id;
    private String term;
    private String definition;
    private LocalDateTime insertDateTime;

    public CardDTO() {
    }

    public CardDTO(CardDocument cardDocument) {
        this.id = cardDocument.getId();
        this.term = cardDocument.getTerm();
        this.definition = cardDocument.getDefinition();
        this.insertDateTime = cardDocument.getInsertDateTime();
    }

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
}
