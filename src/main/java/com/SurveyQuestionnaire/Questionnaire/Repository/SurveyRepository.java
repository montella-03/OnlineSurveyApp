package com.SurveyQuestionnaire.Questionnaire.Repository;

import com.SurveyQuestionnaire.Questionnaire.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
