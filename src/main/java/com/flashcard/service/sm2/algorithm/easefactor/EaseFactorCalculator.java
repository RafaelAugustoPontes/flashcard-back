package com.flashcard.service.sm2.algorithm.easefactor;

import com.flashcard.service.sm2.algorithm.spec.EaseFactorCalcSpec;
import com.flashcard.service.sm2.model.Quality;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EaseFactorCalculator implements EaseFactorCalcSpec {

    private final RoundingMode roundingMode = RoundingMode.UP;

    @Override
    public BigDecimal execute(Quality quality){
        double easeFactor = (0.1 - (5 - quality.getFactor()) * (0.08 + (5 - quality.getFactor()) * 0.02));
        return new BigDecimal(easeFactor).setScale(1, roundingMode);
    }

}
