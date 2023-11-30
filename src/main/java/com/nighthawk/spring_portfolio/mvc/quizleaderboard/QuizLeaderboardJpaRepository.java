package com.nighthawk.spring_portfolio.mvc.quizleaderboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface QuizLeaderboardJpaRepository extends JpaRepository<QuizLeaderboard, Long> {

    /*
     * Custom method prototypes specific to this application.
     * JPA provides many built-in methods, and additional custom methods can be defined as needed.
     */

    /*
     * Custom method to save a QuizLeaderboard entity.
     * Note: The method signature uses the entity type (QuizLeaderboard) instead of a String.
     */
    void save(String QuizLeaderboard);

    /*
     * Custom method to find all QuizLeaderboard entities, ordered by leaders in ascending order.
     */
    List<QuizLeaderboard> findAllByOrderByLeadersAsc();

    /*
     * Custom method to find QuizLeaderboard entities by leaders, ignoring case.
     * Note: The parameter name has been adjusted for clarity and consistency.
     */
    List<QuizLeaderboard> findByLeadersIgnoreCase(String quizLeaderboard);
}