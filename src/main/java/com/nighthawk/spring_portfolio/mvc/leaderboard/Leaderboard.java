package com.nighthawk.spring_portfolio.mvc.leaderboard;

import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Leaderboard {
    @Id
    @Column(unique = true)
    private String userName;  // Change the field name and type

    @Column(unique = true)
    private String leaderboard;

    private int totalScore;

    // starting scores
    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> leaderboardHash = new HashMap<>();
        return leaderboardHash;
    }
}
