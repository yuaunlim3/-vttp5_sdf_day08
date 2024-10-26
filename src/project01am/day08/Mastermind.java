package src.project01am.day08;

import java.io.Console;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        String toGuess = "";
        for (int idx = 0; idx < 4; idx++) {
            int num = rand.nextInt(6) + 1;
            String digit = Integer.toString(num);
            toGuess += digit;
        }
        System.out.println(toGuess);
        boolean win = false;
        Console cons = System.console();
        for (int rounds = 1; rounds < 13; rounds++) {
            System.out.printf("Round %d\n", rounds);
            String guess = cons.readLine("Guess: ");
            if (!guess.matches("[1-6]{4}") || guess.length() != 4) {
                System.out.println("Invalid input");
                guess = cons.readLine("Guess: ");
            }
            String[] guessedDigits = guess.split("");
            int CP = 0;
            int C = 0;
            ArrayList<String> checked = new ArrayList<>();
            for (String digits : guessedDigits) {
                if (toGuess.indexOf(digits) == guess.indexOf(digits)) {
                    CP++;
                    checked.add(digits);
                }
                if (toGuess.contains(digits) && (toGuess.indexOf(digits) != guess.indexOf(digits))) {
                    C++;
                    checked.add(digits);

                }

            }

            System.out.printf("Correct Position and Number: %d\nCorrect Number Wrong Position: %d\n", CP, C);
            if (CP == 4) {
                win = true;
                break;
            }
            System.out.printf("Number of tries left: %d\n", 12 - rounds);
        }

        if (win) {
            System.out.println("WIN");
        } else {
            System.out.printf("You have run out of tries\nThe answer is: %s\n", toGuess);
        }
    }
}
