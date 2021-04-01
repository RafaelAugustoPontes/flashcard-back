package com.flashcard.service.spacedrepetition;

import java.math.BigDecimal;

public class SpacedRepetitionInput {

    private final Quality quality;
    private final Integer repetitions;
    private final BigDecimal previousEaseFactor;
    private final Integer previousInterval;

    public SpacedRepetitionInput(Quality quality, Integer repetitions, BigDecimal previousEaseFactor, Integer previousInterval) {
        this.quality = quality;
        this.repetitions = repetitions;
        this.previousEaseFactor = previousEaseFactor;
        this.previousInterval = previousInterval;
    }

    public Quality getQuality() {
        return quality;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public BigDecimal getPreviousEaseFactor() {
        return previousEaseFactor;
    }

    public Integer getPreviousInterval() {
        return previousInterval;
    }
}
