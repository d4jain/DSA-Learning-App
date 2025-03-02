package com.dsaLearning.learningApp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Service
public class GptService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.model}")
    private String model;

    private final String GPT_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getHint(String leetcodeUrl, String doubt) {
        RestTemplate restTemplate = new RestTemplate();

        String prompt = "A student is struggling with a LeetCode problem: " + leetcodeUrl +
                ". Their doubt is: '" + doubt + "'. Give them a helpful hint or guide them to think in the right direction without providing the direct solution.";

        Map<String, Object> requestBody = Map.of(
                "model", model,
                "messages", new Object[]{
                        Map.of("role", "system", "content", "You are a helpful teaching assistant specializing in data structures and algorithms."),
                        Map.of("role", "user", "content", prompt)
                },
                "max_tokens", 200,
                "temperature", 0.7
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(GPT_API_URL, entity, Map.class);

        Map<String, Object> choices = ((Map<String, Object>) ((java.util.List<?>) response.getBody().get("choices")).get(0));

        Map<String, Object> message = (Map<String, Object>) choices.get("message");

        return (String) message.get("content");
    }
}

