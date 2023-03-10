package com.SurveyQuestionnaire.Questionnaire.Controller;

import com.SurveyQuestionnaire.Questionnaire.Entity.Question;
import com.SurveyQuestionnaire.Questionnaire.Entity.Survey;
import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Model.AnswerModel;
import com.SurveyQuestionnaire.Questionnaire.Model.QuestionModel;
import com.SurveyQuestionnaire.Questionnaire.Model.SurveyModel;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;
import com.SurveyQuestionnaire.Questionnaire.Service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/signUp")
    public String signUp(@RequestBody UserModel userModel){
        User user = questionnaireService.signUp(userModel);

//        sendVerificationEmail(userModel);
        return "registered!, Verify your email to log in.";

    }
    @PostMapping("/saveSurvey")
    public String save(@RequestBody SurveyModel surveyModel) {
        Survey survey = questionnaireService.save(surveyModel);
        return "successfully saved survey";
    }
    @PostMapping("/saveQuestion")
    public String saveQuestions(@RequestBody QuestionModel questionModel){
        Question question = questionnaireService.saveQuestion(questionModel);
        return "question saved successfully";

}
    @PostMapping("/answer")
    public void answerQuestion(@RequestParam Long questionId, @RequestBody AnswerModel answerModel, UserModel userModel) {
        Question question = questionnaireService.getQuestionById(questionId);
        User user = questionnaireService.getUserByEmail(userModel.getName());
        questionnaireService.saveUserAnswer(user, question, answerModel);
    }

//    @GetMapping("/verify-email")
//    public String verifyEmail(@RequestParam("token") String token) {
//         token = UUID.randomUUID().toString();
//        User user = questionnaireService.getUserByVerificationToken(token);
//        if (user == null) {
//            return "Invalid verification token";
//        }
//
//       user.setLogged(true);
//
//        return "Your email has been verified";
//    }

//    private void sendVerificationEmail(UserModel userModel) {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//    String appUrl="";
//
//        String verificationUrl = appUrl + "/verify-email?token=" + userModel.getVerificationToken();
//
//        message.setTo(userModel.getEmail());
//        message.setSubject("Verify your email");
//        message.setText("Please click on this link to verify your email: " + verificationUrl);
//
//        mailSender.send(message);
//    }

}
