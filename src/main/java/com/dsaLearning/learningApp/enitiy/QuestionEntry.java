package com.dsaLearning.learningApp.enitiy;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document (collection = "question_entries")
public class QuestionEntry {

    @Id //Mapping as primary key
    private ObjectId id;
    private String question;
    private String doubt;

    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }
}
