package com.flashcard.repository;

import com.flashcard.document.CardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<CardDocument, String> {

    List<CardDocument> findByCardClassDocumentId(String id);

}
