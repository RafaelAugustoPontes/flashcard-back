package com.flashcard.service.sm2.model;

import java.math.BigDecimal;

public class SpacedRepetitionOutput {

    private Integer interval;
    private Integer repetitions;
    private BigDecimal easeFactor;


    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public BigDecimal getEaseFactor() {
        return easeFactor;
    }

    public void setEaseFactor(BigDecimal easeFactor) {
        this.easeFactor = easeFactor;
    }
}
