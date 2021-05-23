package com.flashcard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private CardController cardController;

    @Test
    public void contextLoads() {
        assertNotNull(cardController);
    }

}
