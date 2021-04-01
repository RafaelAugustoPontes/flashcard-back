package com.flashcard.service;

import com.flashcard.document.CardClassDocument;
import com.flashcard.dto.CardClassDTO;
import com.flashcard.dto.CardDTO;
import com.flashcard.repository.CardClassRepository;
import com.flashcard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardClassService {

    @Autowired
    private CardClassRepository cardClassRepository;

    @Autowired
    private CardRepository cardRepository;

    public ResponseEntity<List<CardClassDTO>> getAll() {
        List<CardClassDTO> cardClassList = cardClassRepository.findAll()
                .stream()
                .map(CardClassDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<List<CardClassDTO>>(cardClassList, HttpStatus.OK);
    }

    public ResponseEntity<CardClassDTO> create(CardClassDTO cardDTO) {
        CardClassDocument cardDocument = new CardClassDocument();
        cardDocument.setName(cardDTO.getName());

        CardClassDocument newCardClass = cardClassRepository.save(cardDocument);

        return new ResponseEntity<CardClassDTO>(new CardClassDTO(newCardClass), HttpStatus.CREATED);
    }

    public ResponseEntity<CardClassDTO> getById(String id) {
        Optional<CardClassDocument> optional = cardClassRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CardClassDocument cardClassDocument = optional.get();

        CardClassDTO cardClassDTO = new CardClassDTO(cardClassDocument);
        return new ResponseEntity<CardClassDTO>(cardClassDTO, HttpStatus.OK);
    }

    public ResponseEntity<CardClassDTO> update(String id, CardClassDTO cardClassDTO) {
        Optional<CardClassDocument> optional = this.cardClassRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CardClassDocument cardClassDocument = optional.get();
        cardClassDocument.setName(cardClassDTO.getName());
        cardClassRepository.save(cardClassDocument);

        return new ResponseEntity<CardClassDTO>(new CardClassDTO(cardClassDocument), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> delete(String id) {
        Optional<CardClassDocument> optional = cardClassRepository.findById(id);
        if (optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CardClassDocument cardClassDocument = optional.get();
        cardClassDocument.getCardDocuments().forEach(cardRepository::delete);
        cardClassRepository.delete(cardClassDocument);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
