package com.flashcard.service.spacedrepetition;

public enum Quality {

    COMPLETE_BLACKOUT(0),
    INCORRECT_RESPONSE_THE_CORRECT_ONE_REMEMBERED(1),
    INCORRECT_RESPONSE_WHERE_CORRECT_EASY_RECALL(2),
    CORRECT_DIFFICULTY(3),
    PERFECT_AFTER_HESITATION(4),
    PERFECT(5),

    ;

    private Integer number;

    Quality(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isCorrect(){
        return this.number >= CORRECT_DIFFICULTY.getNumber();
    }

}
