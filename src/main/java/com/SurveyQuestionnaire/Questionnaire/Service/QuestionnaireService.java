package com.SurveyQuestionnaire.Questionnaire.Service;

import com.SurveyQuestionnaire.Questionnaire.Entity.Question;
import com.SurveyQuestionnaire.Questionnaire.Entity.Survey;
import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Model.AnswerModel;
import com.SurveyQuestionnaire.Questionnaire.Model.QuestionModel;
import com.SurveyQuestionnaire.Questionnaire.Model.SurveyModel;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;

public interface QuestionnaireService {
    public User signUp(UserModel user);

    User getUserByVerificationToken(String token);


    Survey save(SurveyModel surveyModel);

    Question saveQuestion(QuestionModel questionModel);

    Question getQuestionById(Long questionId);

    User getUserByEmail(String name);

    void saveUserAnswer(User user, Question question, AnswerModel answerModel);
}
