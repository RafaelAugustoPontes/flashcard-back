package com.flashcard.service.sm2.algorithm.spec;

import com.flashcard.service.sm2.model.Quality;

import java.math.BigDecimal;

public interface EaseFactorCalcSpec {
    BigDecimal execute(Quality quality);
}
