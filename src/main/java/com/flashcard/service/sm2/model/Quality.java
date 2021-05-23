package com.flashcard.service.sm2.model;

public enum Quality {

    EASY(5),
    NORMAL(3),
    HARD(0);

    private Integer factor;

    Quality(Integer factor) {
        this.factor = factor;
    }

    public Integer getFactor() {
        return factor;
    }


}
