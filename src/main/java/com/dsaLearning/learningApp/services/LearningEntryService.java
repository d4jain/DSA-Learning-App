package com.dsaLearning.learningApp.services;

import com.dsaLearning.learningApp.enitiy.QuestionEntry;
import com.dsaLearning.learningApp.repository.LearningEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LearningEntryService {

    @Autowired
    private LearningEntryRepository learningEntryRepository;

    public void saveEntry(QuestionEntry questionEntry){
        learningEntryRepository.save(questionEntry);
    }

    public List<QuestionEntry> getAll(){
        return learningEntryRepository.findAll();
    }

    public Optional<QuestionEntry> findByID(ObjectId id){
        return learningEntryRepository.findById(id);
    }

    public void deleteByID(ObjectId id){
        learningEntryRepository.deleteById(id);
    }
}

//controller --> service --> repository