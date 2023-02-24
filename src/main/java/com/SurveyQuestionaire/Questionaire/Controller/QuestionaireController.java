package com.SurveyQuestionaire.Questionaire.Controller;

import com.SurveyQuestionaire.Questionaire.Entity.User;
import com.SurveyQuestionaire.Questionaire.Events.RegistrationEvent;
import com.SurveyQuestionaire.Questionaire.Model.UserModel;
import com.SurveyQuestionaire.Questionaire.Service.QuestionnaireService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private ApplicationEventPublisher publisher;
    @PostMapping("/signUp")
    public String signUp(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = questionnaireService.signUp(userModel);
        publisher.publishEvent(new RegistrationEvent(user,applicationUrl(request)));
        return "registered!, Verify your email to log in.";

    }
    private String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
