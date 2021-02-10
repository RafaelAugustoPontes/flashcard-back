package com.flashcard.controller;

import com.flashcard.dto.CardDTO;
import com.flashcard.dto.CardInsertDTO;
import com.flashcard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cards")
@RestController
@CrossOrigin(origins = "*")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAll() {
        return cardService.getAll();
    }

    @GetMapping("/cardsClass/{idCardClass}")
    public ResponseEntity<List<CardDTO>> getByCardClass(@PathVariable String idCardClass) {
        return cardService.getByCardsClassId(idCardClass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getById(@PathVariable String id) {
        return cardService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CardInsertDTO> create(@RequestBody CardInsertDTO cardDTO) {
        return cardService.createCard(cardDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDTO> update(@PathVariable String id, @RequestBody CardDTO cardDTO) {
        return cardService.update(id, cardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return cardService.delete(id);
    }


}
