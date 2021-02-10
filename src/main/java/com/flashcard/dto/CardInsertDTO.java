package com.flashcard.dto;

import com.flashcard.document.CardDocument;

public class CardInsertDTO {

    private String id;
    private String term;
    private String definition;
    private String idCardClass;

    public CardInsertDTO() {
    }

    public CardInsertDTO(CardDocument cardDocument) {
        this.id = cardDocument.getId();
        this.term = cardDocument.getTerm();
        this.definition = cardDocument.getDefinition();
        this.idCardClass = cardDocument.getCardClassDocument().getId();
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

    public String getIdCardClass() {
        return idCardClass;
    }

    public void setIdCardClass(String idCardClass) {
        this.idCardClass = idCardClass;
    }
}
