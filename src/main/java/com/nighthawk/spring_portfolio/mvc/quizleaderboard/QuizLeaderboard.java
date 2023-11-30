package com.nighthawk.spring_portfolio.mvc.quizleaderboard;

import java.util.HashMap;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.

public class QuizLeaderboard {

    /*
     * @Id annotation designates the primary key field of the entity.
     * @GeneratedValue annotation configures the way of incrementing the associated database column's value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Fields representing properties of the QuizLeaderboard entity.
    // private @Column(unique=true) String userName; // (Optional) Uncomment if you want to enforce uniqueness on the userName column.
    private String userName;
    private int totalScore;

    /*
     * A static method to initialize the QuizLeaderboard with starting scores.
     * Uses a HashMap to store the association between user names and their initial scores.
     */
    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> quizLeaders = new HashMap<>();
        return quizLeaders;
    }
}

