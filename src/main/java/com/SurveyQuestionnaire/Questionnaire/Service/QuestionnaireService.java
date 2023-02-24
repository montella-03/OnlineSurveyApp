package com.SurveyQuestionnaire.Questionnaire.Service;

import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;

public interface QuestionnaireService {
    public User signUp(UserModel user);

    User getUserByVerificationToken(String token);
}
