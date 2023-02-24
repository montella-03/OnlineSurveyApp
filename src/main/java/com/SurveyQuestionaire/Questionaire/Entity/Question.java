package com.SurveyQuestionaire.Questionaire.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String type; //"multiple choice", "open-ended"

}
