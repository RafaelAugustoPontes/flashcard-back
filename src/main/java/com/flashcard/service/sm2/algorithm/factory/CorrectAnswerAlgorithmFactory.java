package com.flashcard.service.sm2.algorithm.factory;

import com.flashcard.service.sm2.algorithm.easefactor.EaseFactorCalculator;
import com.flashcard.service.sm2.algorithm.impl.CorrectAnswerImpl;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithm;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithmFactory;

public class CorrectAnswerAlgorithmFactory extends QualityAlgorithmFactory {

    @Override
    public QualityAlgorithm create() {
        return new CorrectAnswerImpl(new EaseFactorCalculator());
    }

}
