package com.dsaLearning.learningApp.controller;

import com.dsaLearning.learningApp.dto.DoubtRequest;
import com.dsaLearning.learningApp.dto.DoubtResponse;
import com.dsaLearning.learningApp.services.DsaLearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoubtController {

    @Autowired
    private DsaLearningService dsaLearningService;

    @PostMapping("/api/doubt")
    public DoubtResponse getDoubtResponse(@RequestBody DoubtRequest request) {
        System.out.println("Received request: " + request.getLeetCodeUrl() + " | " + request.getDoubt()); // Debug log
        return dsaLearningService.getHint(request);
    }

}

//
//import com.dsaLearning.learningApp.dto.DoubtRequest;
//import com.dsaLearning.learningApp.dto.DoubtResponse;
//import com.dsaLearning.learningApp.services.GptService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/doubt")
//public class DoubtController {
//
//    private final GptService gptService;
//
//    public DoubtController(GptService gptService) {
//        this.gptService = gptService;
//    }
//
//    @PostMapping("/submit")
//    public DoubtResponse submitDoubt(@RequestBody DoubtRequest request) {
//        String hint = "Here’s a helpful hint for your LeetCode problem!";
//        return new DoubtResponse(hint); // This should work
//    }
//}