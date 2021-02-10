package com.flashcard.controller;

import com.flashcard.dto.CardClassDTO;
import com.flashcard.service.CardClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cardClasses")
@RestController
@CrossOrigin(origins = "*")
public class CardClassController {

    @Autowired
    private CardClassService cardClassService;

    @GetMapping
    public ResponseEntity<List<CardClassDTO>> getAll() {
        return cardClassService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardClassDTO> getById(@PathVariable String id) {
        return cardClassService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CardClassDTO> create(@RequestBody CardClassDTO CardClassDTO) {
        return cardClassService.create(CardClassDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardClassDTO> update(@PathVariable String id, @RequestBody CardClassDTO CardClassDTO) {
        return cardClassService.update(id, CardClassDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return cardClassService.delete(id);
    }

}
