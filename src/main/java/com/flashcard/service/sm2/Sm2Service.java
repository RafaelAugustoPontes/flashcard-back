package com.flashcard.service.sm2;


import com.flashcard.service.sm2.algorithm.factory.CorrectAnswerAlgorithmFactory;
import com.flashcard.service.sm2.algorithm.factory.IncorretAnswerAlgorithmFactory;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithmFactory;
import com.flashcard.service.sm2.model.Quality;
import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Sm2Service {

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input) {
        QualityAlgorithmFactory qualityAlgorithmFactory = getFactory(input);
        SpacedRepetitionOutput output = qualityAlgorithmFactory.execute(input);

        adjustEaseFactor(output);

        return output;
    }

    private QualityAlgorithmFactory getFactory(SpacedRepetitionInput input) {
        if (Quality.NORMAL.equals(input.getQuality()) || Quality.EASY.equals(input.getQuality())) {
            return new CorrectAnswerAlgorithmFactory();
        }
        return new IncorretAnswerAlgorithmFactory();
    }

    private void adjustEaseFactor(SpacedRepetitionOutput output) {
        BigDecimal minEaseFactor = new BigDecimal("1.3");
        if (output.getEaseFactor().compareTo(minEaseFactor) < 0) {
            output.setEaseFactor(minEaseFactor);
        }
    }

}
