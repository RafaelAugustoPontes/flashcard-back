package com.flashcard.service.spacedrepetition;

import java.math.BigDecimal;

public class SpacedRepetitionOutput {

    private final Integer interval;
    private final Integer repetitions;
    private final BigDecimal easeFactor;

    public SpacedRepetitionOutput(Integer interval, Integer repetitions, BigDecimal easeFactor) {
        this.interval = interval;
        this.repetitions = repetitions;
        this.easeFactor = easeFactor;
    }

    public Integer getInterval() {
        return interval;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public BigDecimal getEaseFactor() {
        return easeFactor;
    }
}
