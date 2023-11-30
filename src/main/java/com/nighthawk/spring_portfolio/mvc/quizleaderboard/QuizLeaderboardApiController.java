package com.nighthawk.spring_portfolio.mvc.quizleaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizleaders")
@CrossOrigin(origins="https://cosmic-carnage.github.io/")

public class QuizLeaderboardApiController {

    /*
     * @Autowired annotation injects the QuizLeaderboardJpaRepository bean into the controller.
     */
    @Autowired
    private QuizLeaderboardJpaRepository repository;

    /*
     * Endpoint for retrieving the entire leaderboard.
     * @GetMapping annotation maps HTTP GET requests to this method.
     */
    @GetMapping("/")
    public ResponseEntity<List<QuizLeaderboard>> getLeaderboard() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /*
     * Endpoint for adding a score to a specific leaderboard entry.
     * @PostMapping annotation maps HTTP POST requests to this method.
     * @PathVariable annotations extract values from the URI path.
     */
    @PostMapping("/addScore/{id}/{totalScore}")
    public ResponseEntity<QuizLeaderboard> addScore(@PathVariable long id, @PathVariable int totalScore) {
        Optional<QuizLeaderboard> optional = repository.findById(id);
        if (optional.isPresent()) {
            QuizLeaderboard quizLeaderboard = optional.get();
            quizLeaderboard.setTotalScore(quizLeaderboard.getTotalScore() + totalScore);
            repository.save(quizLeaderboard);
            return new ResponseEntity<>(quizLeaderboard, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
     * Endpoint for deleting a specific leaderboard entry.
     * @DeleteMapping annotation maps HTTP DELETE requests to this method.
     * @PathVariable annotation extracts the id from the URI path.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<QuizLeaderboard> deleteLeaderboard(@PathVariable long id) {
        Optional<QuizLeaderboard> optional = repository.findById(id);
        if (optional.isPresent()) {
            QuizLeaderboard quizLeaderboard = optional.get();
            repository.deleteById(id);
            return new ResponseEntity<>(quizLeaderboard, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
     * Endpoint for creating a new leaderboard entry.
     * @PostMapping annotation maps HTTP POST requests to this method.
     * @PathVariable annotations extract values from the URI path.
     */
    @PostMapping("/post/{userName}/{totalScore}")
    public ResponseEntity<QuizLeaderboard> postQuizLeaderboard(@PathVariable String userName, @PathVariable int totalScore) {
        // A person object WITHOUT ID will create a new record with default roles as student
        QuizLeaderboard quizLeaderboard = new QuizLeaderboard(null, userName, totalScore);
        repository.save(quizLeaderboard);
        return new ResponseEntity<>(quizLeaderboard, HttpStatus.OK);
    }
}