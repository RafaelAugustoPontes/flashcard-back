package com.flashcard.service.sm2.algorithm.factory;

import com.flashcard.service.sm2.algorithm.impl.IncorrectAnswerImpl;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithm;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithmFactory;

public class IncorretAnswerAlgorithmFactory extends QualityAlgorithmFactory {

    @Override
    protected QualityAlgorithm create() {
        return new IncorrectAnswerImpl();
    }

}
