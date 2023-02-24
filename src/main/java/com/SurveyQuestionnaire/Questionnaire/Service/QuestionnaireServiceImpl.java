package com.SurveyQuestionnaire.Questionnaire.Service;

import com.SurveyQuestionnaire.Questionnaire.Entity.Question;
import com.SurveyQuestionnaire.Questionnaire.Entity.Survey;
import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Entity.UserAnswer;
import com.SurveyQuestionnaire.Questionnaire.Model.AnswerModel;
import com.SurveyQuestionnaire.Questionnaire.Model.QuestionModel;
import com.SurveyQuestionnaire.Questionnaire.Model.SurveyModel;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;
import com.SurveyQuestionnaire.Questionnaire.Repository.QuestionRepository;
import com.SurveyQuestionnaire.Questionnaire.Repository.SurveyRepository;
import com.SurveyQuestionnaire.Questionnaire.Repository.UserAnswerRepository;
import com.SurveyQuestionnaire.Questionnaire.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private UserAnswerRepository userAnswerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public User signUp(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserByVerificationToken(String token) {
        User user = userRepository.findByToken(token);
        return user;
    }

    @Override
    public Survey save(SurveyModel surveyModel) {
        Survey survey = new Survey();
        survey.setTitle(surveyModel.getTitle());
        survey.setDescription(surveyModel.getDescription());
        return surveyRepository.save(survey);
    }

    @Override
    public Question saveQuestion(QuestionModel questionModel) {
        Question question = new Question();
        question.setText(questionModel.getText());

        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        Question question = questionRepository.findById(questionId).get();
        return question;
    }

    @Override
    public User getUserByEmail(String name) {
        User user = userRepository.findByEmail(name);
        return user;
    }

    public void saveUserAnswer(User user, Question question, AnswerModel answerModel) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        userAnswer.setAnswer(answerModel.getText());
        userAnswerRepository.save(userAnswer);
    }


}
