package com.SurveyQuestionnaire.Questionnaire.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String name;
       private String email;
    private String password;
    private String verificationToken;
    private String matchingPassword;
}
