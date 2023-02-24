package com.SurveyQuestionaire.Questionaire.Error;

public class ErrorHandling extends Exception {

    public ErrorHandling() {
        super();
    }

    public ErrorHandling(String message) {
        super(message);
    }

    public ErrorHandling(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorHandling(Throwable cause) {
        super(cause);
    }

    protected ErrorHandling(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
