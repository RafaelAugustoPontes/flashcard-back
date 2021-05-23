package com.flashcard.service.sm2.algorithm.spec;

import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

public interface QualityAlgorithm {
    SpacedRepetitionOutput execute(SpacedRepetitionInput input);
}
