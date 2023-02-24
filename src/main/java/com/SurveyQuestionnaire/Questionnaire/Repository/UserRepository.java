package com.SurveyQuestionnaire.Questionnaire.Repository;

import com.SurveyQuestionnaire.Questionnaire.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM users WHERE token = ?1", nativeQuery = true)
    User findByToken(String token);
}
