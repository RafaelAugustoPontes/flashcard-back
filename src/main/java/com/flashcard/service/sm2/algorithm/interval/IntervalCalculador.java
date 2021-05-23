package com.flashcard.service.sm2.algorithm.interval;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IntervalCalculador extends Interval {

    public IntervalCalculador(Interval interval) {
        super(interval);
    }

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input, SpacedRepetitionOutput output) {
        BigDecimal result = input.getPreviousEaseFactor().multiply(new BigDecimal(input.getPreviousInterval()));
        BigDecimal newInterval = result.setScale(1, RoundingMode.UP);
        output.setInterval(newInterval.intValue());

        return next(input, output);
    }
}
