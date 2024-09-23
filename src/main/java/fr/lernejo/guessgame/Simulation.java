package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player has guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("You won!");
            return true;
        } else if (guess < numberToGuess) {
            player.respond(true);
            logger.log("Guess was lower.");
        } else {
            player.respond(false);
            logger.log("Guess was greater.");
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long startTime = System.currentTimeMillis();
        long iterations = 0;
        boolean success = false;

        while (iterations < maxIterations && !success) {
            success = nextRound();
            iterations++;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long minutes = duration / 60000;
        long seconds = (duration % 60000) / 1000;
        long millis = duration % 1000;

        if (success) {
            logger.log(String.format("You won! Time taken: %02d:%02d.%03d", minutes, seconds, millis));
        } else {
            logger.log(String.format("You lost! Time taken: %02d:%02d.%03d", minutes, seconds, millis));
        }
    }
}
