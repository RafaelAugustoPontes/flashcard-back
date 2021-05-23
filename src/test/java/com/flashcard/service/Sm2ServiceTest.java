package com.flashcard.service;

import com.flashcard.service.sm2.Sm2Service;
import com.flashcard.service.sm2.model.Quality;
import com.flashcard.service.sm2.model.SpacedRepetitionInput;
import com.flashcard.service.sm2.model.SpacedRepetitionOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class Sm2ServiceTest {

    private Sm2Service sm2Service;

    @BeforeEach
    void setUp() {
        sm2Service = new Sm2Service();
    }

    @Test
    void execute_caseTeste1() {
        SpacedRepetitionInput input = new SpacedRepetitionInput(
                Quality.NORMAL,
                0,
                new BigDecimal("2.5"),
                0
        );
        SpacedRepetitionOutput output = sm2Service.execute(input);
        Assertions.assertEquals(1, output.getInterval());
        Assertions.assertEquals(1, output.getRepetitions());
        Assertions.assertEquals(new BigDecimal("2.3"), output.getEaseFactor());
    }

    @Test
    void execute_caseTeste2() {
        SpacedRepetitionInput input = new SpacedRepetitionInput(
                Quality.HARD,
                0,
                new BigDecimal("2.5"),
                0
        );

        SpacedRepetitionOutput output = sm2Service.execute(input);
        Assertions.assertEquals(0, output.getRepetitions());
        Assertions.assertEquals(1, output.getInterval());
        Assertions.assertEquals(input.getPreviousEaseFactor(), output.getEaseFactor());
    }

    @Test
    void execute_caseTeste3() {
        SpacedRepetitionInput input = new SpacedRepetitionInput(
                Quality.HARD,
                0,
                new BigDecimal("1.0"),
                0
        );

        SpacedRepetitionOutput output = sm2Service.execute(input);
        Assertions.assertEquals(new BigDecimal("1.3"), output.getEaseFactor());
    }

}