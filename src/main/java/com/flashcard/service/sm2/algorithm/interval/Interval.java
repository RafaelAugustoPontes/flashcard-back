package com.flashcard.service.sm2.algorithm.interval;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public abstract class Interval {

    private Interval interval;

    public Interval(Interval interval) {
        this.interval = interval;
    }

    public abstract SpacedRepetitionOutput execute(SpacedRepetitionInput input, SpacedRepetitionOutput output) ;

    protected SpacedRepetitionOutput next(SpacedRepetitionInput input, SpacedRepetitionOutput output){
        if (interval != null)
            return interval.execute(input, output);
        return output;
    }

}
