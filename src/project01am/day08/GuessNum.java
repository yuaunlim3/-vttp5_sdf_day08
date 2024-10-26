package src.project01am.day08;

import java.io.Console;
import java.security.SecureRandom;
import java.util.Random;

public class GuessNum {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        int toGuess = rand.nextInt(900000) + 100000;
        boolean isCorrect = false;
        System.out.println(toGuess);

        Console cons = System.console();

        while(!isCorrect){
            int guess = Integer.parseInt(cons.readLine("Guess: "));
            if(guess == toGuess){
                isCorrect = true;
            }else if(guess > toGuess){
                System.out.println("Your number is too high");
            }else if(guess < toGuess){
                System.out.println("Your number is too low");
            }
        }

        String input = cons.readLine("Restart (Y/N)\n>>>");
        if(getFirst(input).equalsIgnoreCase("y")){
            main(null);
        }else{
            System.exit(0);
        }
    }

    private static String getFirst(String input){
        String[] inputs = input.split("");
        System.out.println(inputs[0]);
        return inputs[0].toLowerCase().trim();
    }
}
