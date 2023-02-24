package com.SurveyQuestionaire.Questionaire.Repository;

import com.SurveyQuestionaire.Questionaire.Entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long> {
}
