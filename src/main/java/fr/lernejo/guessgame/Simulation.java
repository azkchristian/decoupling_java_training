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

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {
            // Continue until the player guesses the correct number
        }
    }
}
