package com.flashcard.service.sm2.algorithm.impl;

import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithm;
import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public class IncorrectAnswerImpl implements QualityAlgorithm {

    @Override
    public SpacedRepetitionOutput execute(SpacedRepetitionInput input) {
        SpacedRepetitionOutput output = new SpacedRepetitionOutput();
        output.setRepetitions(0);
        output.setInterval(1);
        output.setEaseFactor(input.getPreviousEaseFactor());

        return output;
    }

}
