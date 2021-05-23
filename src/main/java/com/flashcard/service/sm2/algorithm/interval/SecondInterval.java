package com.flashcard.service.sm2.algorithm.interval;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public class SecondInterval extends Interval {

    public SecondInterval(Interval interval) {
        super(interval);
    }

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input, SpacedRepetitionOutput output) {
        if (input.getRepetitions().equals(1)) {
            output.setInterval(6);
            return output;
        }
        return next(input, output);
    }
}
