package com.SurveyQuestionnaire.Questionnaire.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}
