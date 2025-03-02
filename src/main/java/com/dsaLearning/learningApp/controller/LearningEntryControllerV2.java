package com.dsaLearning.learningApp.controller;

import com.dsaLearning.learningApp.enitiy.QuestionEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.dsaLearning.learningApp.services.LearningEntryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_learning")
public class LearningEntryControllerV2 {

    @Autowired
    private LearningEntryService learningEntryService;

    @GetMapping("/questionsList")
    public List<QuestionEntry> getAll(){
        return learningEntryService.getAll();
    }

    @PostMapping
    public QuestionEntry createEntry(@RequestBody QuestionEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        learningEntryService.saveEntry(myEntry);
        return myEntry ;
    }

    @GetMapping("/id/{id}")
    public QuestionEntry getQuestionEntryByID(@PathVariable ObjectId id){
        return learningEntryService.findByID(id).orElse(null);
    }

    @DeleteMapping ("/id/{id}")
    public boolean deleteQuestionEntryByID(@PathVariable ObjectId id){
        learningEntryService.deleteByID(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public QuestionEntry updateEntry(@PathVariable ObjectId id ,@RequestBody QuestionEntry newEntry){
        QuestionEntry old = learningEntryService.findByID(id).orElse(null);

        if(old!=null){
            old.setDoubt(newEntry.getDoubt()!=null && !newEntry.getDoubt().equals("")? newEntry.getDoubt() : old.getDoubt());
            old.setQuestion(newEntry.getQuestion()!=null && !newEntry.getQuestion().equals("")? newEntry.getQuestion() : old.getQuestion());
        }
        learningEntryService.saveEntry(old);
        return old ;
    }
}
