package com.nighthawk.spring_portfolio.mvc.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardApiController {

    @Autowired
    private LeaderboardJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Leaderboard>> getLeaderboard() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addScore/{userName}/{totalScore}")  // Change path variable from "id" to "userName"
    public ResponseEntity<Leaderboard> addScore(@PathVariable String userName, @PathVariable int totalScore) {
        Optional<Leaderboard> optional = repository.findById(userName);
        if (optional.isPresent()) {
            Leaderboard leaderboard = optional.get();
            leaderboard.setTotalScore(leaderboard.getTotalScore() + totalScore);
            repository.save(leaderboard);
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{userName}")  // Change path variable from "id" to "userName"
    public ResponseEntity<Leaderboard> deleteLeaderboard(@PathVariable String userName) {
        Optional<Leaderboard> optional = repository.findById(userName);
        if (optional.isPresent()) {
            Leaderboard leaderboard = optional.get();
            repository.deleteById(userName);
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post/{leaderboard}/{totalScore}")
    public ResponseEntity<Leaderboard> postLeaderboard(@PathVariable String leaderboard, @PathVariable int totalScore) {
        // A person object WITHOUT ID will create a new record with default roles as student
        Leaderboard leaderboardrepo = new Leaderboard(null, leaderboard, totalScore);
        repository.save(leaderboardrepo);
        return new ResponseEntity<>(leaderboardrepo, HttpStatus.OK);
    }
}
