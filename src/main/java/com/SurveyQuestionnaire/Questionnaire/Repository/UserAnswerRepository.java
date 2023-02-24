package com.SurveyQuestionnaire.Questionnaire.Repository;

import com.SurveyQuestionnaire.Questionnaire.Entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long> {
}
