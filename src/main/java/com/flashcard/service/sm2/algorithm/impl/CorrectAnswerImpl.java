package com.flashcard.service.sm2.algorithm.impl;

import com.flashcard.service.sm2.algorithm.interval.FirstInterval;
import com.flashcard.service.sm2.algorithm.interval.Interval;
import com.flashcard.service.sm2.algorithm.interval.IntervalCalculador;
import com.flashcard.service.sm2.algorithm.interval.SecondInterval;
import com.flashcard.service.sm2.algorithm.spec.EaseFactorCalcSpec;
import com.flashcard.service.sm2.algorithm.spec.QualityAlgorithm;
import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;

import java.math.BigDecimal;

public class CorrectAnswerImpl implements QualityAlgorithm {

    private EaseFactorCalcSpec easeFactorCalcSpec;

    public CorrectAnswerImpl(EaseFactorCalcSpec easeFactorCalcSpec) {
        this.easeFactorCalcSpec = easeFactorCalcSpec;
    }

    @Override
    public SpacedRepetitionOutput execute(SpacedRepetitionInput input) {
        SpacedRepetitionOutput output = new SpacedRepetitionOutput();
        Interval terceiro = new IntervalCalculador(null);
        Interval segundo = new SecondInterval(terceiro);
        Interval primeiro = new FirstInterval(segundo);
        output = primeiro.execute(input, output);
        output.setRepetitions(input.getRepetitions() + 1);
        BigDecimal easeFactorResult = easeFactorCalcSpec.execute(input.getQuality());
        output.setEaseFactor(input.getPreviousEaseFactor().add(easeFactorResult));

        return output;
    }

}
