package com.SurveyQuestionnaire.Questionnaire.Events;

import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import org.springframework.context.ApplicationEvent;

public class RegistrationEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;

    public RegistrationEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
