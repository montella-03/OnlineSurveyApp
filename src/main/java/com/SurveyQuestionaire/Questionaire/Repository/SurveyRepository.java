package com.SurveyQuestionaire.Questionaire.Repository;

import com.SurveyQuestionaire.Questionaire.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
