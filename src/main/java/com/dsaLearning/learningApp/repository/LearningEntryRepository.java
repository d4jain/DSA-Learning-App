package com.dsaLearning.learningApp.repository;

import com.dsaLearning.learningApp.enitiy.QuestionEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LearningEntryRepository extends MongoRepository<QuestionEntry, ObjectId> {

}
