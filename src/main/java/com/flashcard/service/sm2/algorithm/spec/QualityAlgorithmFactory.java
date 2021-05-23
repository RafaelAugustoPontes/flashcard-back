package com.flashcard.service.sm2.algorithm.spec;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public abstract class QualityAlgorithmFactory {

    protected abstract QualityAlgorithm create();

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input){
        QualityAlgorithm qualityAlgorithm = create();
        return qualityAlgorithm.execute(input);
    }

}
