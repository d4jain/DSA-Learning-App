package com.dsaLearning.learningApp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubtRequest {
    private String leetcodeUrl;
    private String doubt;

    // Constructor
//    public DoubtRequest(String leetCodeUrl, String doubt) {
//        this.leetcodeUrl = leetCodeUrl;
//        this.doubt = doubt;
//    }

    // Getters
    public String getLeetCodeUrl() {
        return leetcodeUrl;
    }

    public String getDoubt() {
        return doubt;
    }

    // Setters (if needed)
    public void setLeetCodeUrl(String leetCodeUrl) {
        this.leetcodeUrl = leetCodeUrl;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }
}