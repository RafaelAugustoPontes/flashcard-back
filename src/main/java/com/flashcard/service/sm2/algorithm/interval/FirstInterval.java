package com.flashcard.service.sm2.algorithm.interval;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public class FirstInterval extends Interval {

    public FirstInterval(Interval interval) {
        super(interval);
    }

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input, SpacedRepetitionOutput output) {
        if (input.getRepetitions().equals(0)) {
            output.setInterval(1);
            return output;
        }
        return next(input, output);
    }
}
