package src.project01am.day08;

import java.io.Console;
import java.security.SecureRandom;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        String toGuess = "";
        for(int idx = 0; idx < 4; idx++){
            int num = rand.nextInt(6) + 1;
            String digit = Integer.toString(num);
            toGuess += digit;
        }
        System.out.println(toGuess);
        boolean win = false;
        Console cons = System.console();
        for(int rounds = 1; rounds < 5; rounds++){
            System.out.printf("Round %d\n",rounds);
            String guess = cons.readLine("Guess: ");
            if(Integer.parseInt(guess) > 6666 || Integer.parseInt(guess) < 1111 ){
                System.out.println("Invalid input");
                guess = cons.readLine("Guess: ");
            }
            String[] guessedDigits = guess.split("");
            int CP = 0;
            int C = 0;
            for(String digits: guessedDigits){
                if(toGuess.indexOf(digits) == guess.indexOf(digits)){
                    CP++;
                }
                if((toGuess.contains(digits) && (toGuess.indexOf(digits) != guess.indexOf(digits)))){
                    C++;
                }
            }

            System.out.printf("CP: %d\nC: %d\n",CP,C);
            if(CP == 4){
                win = true;
                break;
            }
        }

        if(win){
            System.out.println("WIN");
        }else{
            System.out.printf("The answer is: %s\n",toGuess);
        }
    }
}
