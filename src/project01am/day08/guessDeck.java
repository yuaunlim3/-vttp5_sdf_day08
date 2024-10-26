package src.project01am.day08;

import java.io.Console;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class guessDeck {
    protected Queue<Integer> deck;
    protected int toGuessedNumber;
    private List<Integer> higher;
    private List<Integer> lower;

    public guessDeck() {
        this.deck = new LinkedList<>();
        this.higher = new ArrayList<>();
        this.lower = new ArrayList<>();
    }

    public void createDeck() {
        int numCards = 0;
        Random rand = new SecureRandom();
        while (numCards < 10) {
            int number = rand.nextInt(100) + 1;
            if (this.deck.contains(number)) {
                continue;
            } else {
               //System.out.println(number);
                deck.add(number);
                numCards++;
            }
        }
    }

    public void getFirstCard() {
        this.toGuessedNumber = this.deck.poll();
    }

    private void check(int guessedNum, String input) {
        String answer = "";
        if (this.higher.contains(guessedNum)) {
            answer = "higher";
        } else if (this.lower.contains(guessedNum)) {
            answer = "lower";
        }

        if (answer.equalsIgnoreCase(input)) {
            System.out.println("You are correct");
        }
        else{System.out.println("Your guess is wrong");}
    }

    private void printList(){
        String high ="[";
        for(int num:this.higher){
            high = String.join(" ",high,Integer.toString(num));
        }
        high += "]";

        System.out.printf("This is the list of higher numbers: %s\n",high);


        String low ="[";
        for(int num:this.lower){
            low = String.join(" ",low,Integer.toString(num));
        }
        low += "]";

        System.out.printf("This is the list of lower numbers: %s\n",low);
    }

    public void guess() {
        //System.out.println("=========================================");
        getFirstCard();
        int guessedNum = this.deck.poll();
        if (guessedNum > toGuessedNumber) {
            this.higher.add(guessedNum);
        } else {
            this.lower.add(guessedNum);
        }

        while (!this.deck.isEmpty()) {
            int num = this.deck.poll();
            //System.out.println(num);
            if (num > toGuessedNumber) {
                this.higher.add(num);
            } else {
                this.lower.add(num);
            }

        }
        Console cons = System.console();
        System.out.printf("Your Number is %d\n", guessedNum);
        String guess = cons.readLine("Guess>>> ");
        check(guessedNum, guess);
        printList();
        System.out.printf("First Number: %d\n",this.toGuessedNumber);
    }
}
