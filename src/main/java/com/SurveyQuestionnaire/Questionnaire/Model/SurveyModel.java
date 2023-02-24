package com.SurveyQuestionnaire.Questionnaire.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyModel {
    private String title;
    private String description;
    private Date duration;
}
