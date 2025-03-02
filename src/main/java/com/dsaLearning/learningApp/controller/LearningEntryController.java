//package com.dsaLearning.learningApp.controller;
//
//import com.dsaLearning.learningApp.enitiy.QuestionEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/_learning")
//public class LearningEntryController {
//
//    private Map<Long, QuestionEntry> questionEntries = new HashMap<>();
//
//    @GetMapping("/questionsList")
//    public List<QuestionEntry> getAll(){
//
//        return new ArrayList<>(questionEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody QuestionEntry myEntry){
//
//        questionEntries.put(myEntry.getId() , myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{id}")
//    public QuestionEntry getQuestionEntryByID(@PathVariable long id){
//        return questionEntries.get(id);
//    }
//
//    @DeleteMapping ("/id/{id}")
//    public QuestionEntry deleteQuestionEntryByID(@PathVariable long id){
//        return questionEntries.remove(id);
//    }
//
//    @PutMapping("/id/{id}")
//    public QuestionEntry updateEntry(@PathVariable long id ,@RequestBody QuestionEntry myEntry){
//
//        return questionEntries.put(id, myEntry);
//
//    }
//}
