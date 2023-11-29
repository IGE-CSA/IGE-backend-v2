package com.nighthawk.spring_portfolio.mvc.leaderboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardJpaRepository extends JpaRepository<Leaderboard, String> {  // Change Long to String

    // Replace Long with String in the method signature
    void save(String userName);

    List<Leaderboard> findAllByOrderByLeaderboardAsc();
    
    // Replace Long with String in the method signature
    List<Leaderboard> findByLeaderboardIgnoreCase(String leaderboard);
}
