package com.flashcard.service;

import com.flashcard.document.CardClassDocument;
import com.flashcard.document.CardDocument;
import com.flashcard.dto.CardDTO;
import com.flashcard.dto.CardInsertDTO;
import com.flashcard.repository.CardClassRepository;
import com.flashcard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardClassRepository cardClassRepository;

    public ResponseEntity<List<CardDTO>> getAll() {
        List<CardDTO> allCards = cardRepository.findAll()
                .stream()
                .map(CardDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<List<CardDTO>>(allCards, HttpStatus.OK);
    }

    public ResponseEntity<CardDTO> getById(String id) {
        Optional<CardDocument> optional = cardRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<CardDTO>(new CardDTO(optional.get()), HttpStatus.OK);
    }

    public ResponseEntity<CardInsertDTO> createCard(CardInsertDTO cardDTO) {
        CardDocument card = new CardDocument();
        card.setInsertDateTime(LocalDateTime.now());
        card.setTerm(cardDTO.getTerm());
        card.setDefinition(cardDTO.getDefinition());

        CardClassDocument classDocument = cardClassRepository.findById(cardDTO.getIdCardClass()).orElseThrow(RuntimeException::new);
        classDocument.addCard(card);
        card.setCardClassDocument(classDocument);

        CardDocument newCard = cardRepository.save(card);
        cardClassRepository.save(classDocument);

        return new ResponseEntity<CardInsertDTO>(new CardInsertDTO(newCard), HttpStatus.CREATED);
    }

    public ResponseEntity<CardDTO> update(final String id, CardDTO cardDTO) {
        Optional<CardDocument> optional = cardRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CardDocument cardDocument = optional.get();
        cardDocument.setTerm(cardDTO.getTerm());
        cardDocument.setDefinition(cardDTO.getDefinition());
        cardRepository.save(cardDocument);

        return new ResponseEntity<CardDTO>(new CardDTO(cardDocument), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(final String id) {
        Optional<CardDocument> optional = cardRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        cardRepository.delete(optional.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<CardDTO>> getByCardsClassId(String id) {
        List<CardDTO> cards = cardRepository.findByCardClassDocumentId(id)
                .stream()
                .map(CardDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<List<CardDTO>>(cards, HttpStatus.OK);
    }
}
