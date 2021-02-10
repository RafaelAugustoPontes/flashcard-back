package com.flashcard.repository;

import com.flashcard.document.CardClassDocument;
import com.flashcard.document.CardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardClassRepository extends MongoRepository<CardClassDocument, String> {

}
