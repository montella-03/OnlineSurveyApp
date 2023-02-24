package com.SurveyQuestionnaire.Questionnaire.Controller;

import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;
import com.SurveyQuestionnaire.Questionnaire.Service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.url}")
    private String appUrl;
    @PostMapping("/signUp")
    public String signUp(@RequestBody UserModel userModel){
        User user = questionnaireService.signUp(userModel);

        sendVerificationEmail(userModel);
        return "registered!, Verify your email to log in.";

    }
    @GetMapping("/verify-email")
    public String verifyEmail(@RequestParam("token") String token) {
         token = UUID.randomUUID().toString();
        User user = questionnaireService.getUserByVerificationToken(token);
        if (user == null) {
            return "Invalid verification token";
        }

       user.setLogged(true);

        return "Your email has been verified";
    }

    private void sendVerificationEmail(UserModel userModel) {
        SimpleMailMessage message = new SimpleMailMessage();

        String verificationUrl = appUrl + "/verify-email?token=" + userModel.getVerificationToken();

        message.setTo(userModel.getEmail());
        message.setSubject("Verify your email");
        message.setText("Please click on this link to verify your email: " + verificationUrl);

        mailSender.send(message);
    }

}
