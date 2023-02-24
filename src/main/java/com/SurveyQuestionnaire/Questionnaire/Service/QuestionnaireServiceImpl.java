package com.SurveyQuestionnaire.Questionnaire.Service;

import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import com.SurveyQuestionnaire.Questionnaire.Model.UserModel;
import com.SurveyQuestionnaire.Questionnaire.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User signUp(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setVerificationToken(userModel.getVerificationToken());
        return userRepository.save(user);
    }

    @Override
    public User getUserByVerificationToken(String token) {
        User user = userRepository.findByToken(token);
        return user;
    }
}
