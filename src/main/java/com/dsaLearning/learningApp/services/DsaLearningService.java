package com.dsaLearning.learningApp.services;

import com.dsaLearning.learningApp.dto.DoubtRequest;
import com.dsaLearning.learningApp.dto.DoubtResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class DsaLearningService {
    private final Map<String, List<String>> prompts;

    public DsaLearningService() {
        prompts = new HashMap<>();

        prompts.put("array", List.of(
                "What patterns do you notice in the problem? Could sorting or using a hash map help in any way?",
                "Can you think of a way to reduce time complexity by using a two-pointer approach?",
                "How would you efficiently check for duplicates or find pairs in this array?"
        ));

        prompts.put("recursion", List.of(
                "Can you break the problem down into smaller subproblems and use recursion to solve them?",
                "What base case would you define for this recursive solution?",
                "Is there a way to avoid repeated calculations using memoization or dynamic programming?"
        ));

        prompts.put("graph", List.of(
                "Would a depth-first search (DFS) or breadth-first search (BFS) be more appropriate here, and why?",
                "How can you use recursion to traverse this tree while keeping track of node states?",
                "Does this graph problem require finding connected components or shortest paths?"
        ));
    }

    public DoubtResponse getHint(DoubtRequest request) {
        String problemType = identifyProblemType(request.getLeetCodeUrl());
        List<String> possiblePrompts = prompts.getOrDefault(problemType, List.of("Could you clarify what part of the problem is confusing?"));

        String selectedPrompt = possiblePrompts.get(new Random().nextInt(possiblePrompts.size()));

        return new DoubtResponse(selectedPrompt);
    }

    private String identifyProblemType(String leetCodeUrl) {
        System.out.println("LeetCode URL received: " + leetCodeUrl); // Debug log
        if (leetCodeUrl.contains("array")) return "array";
        if (leetCodeUrl.contains("recursion")) return "recursion";
        if (leetCodeUrl.contains("graph")) return "graph";
        System.out.println("Problem type identified as: general"); // Debug log
        return "general";
    }
}

