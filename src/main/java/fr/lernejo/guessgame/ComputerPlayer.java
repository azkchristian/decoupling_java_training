package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        long guess = (min + max) / 2;
        logger.log("Computer guess: " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            min = (min + max) / 2 + 1;
        } else {
            max = (min + max) / 2 - 1;
        }
    }
}
