package com.SurveyQuestionnaire.Questionnaire.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "answers")

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
