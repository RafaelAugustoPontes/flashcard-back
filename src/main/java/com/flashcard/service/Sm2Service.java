package com.flashcard.service;


import com.flashcard.service.spacedrepetition.SpacedRepetitionInput;
import com.flashcard.service.spacedrepetition.SpacedRepetitionOutput;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Sm2Service {

    public SpacedRepetitionOutput execute(SpacedRepetitionInput input){
        Integer repetitions = 0;
        Integer interval = 1;
        BigDecimal easeFactor = new BigDecimal("2.5");

        return null;


    }

}
