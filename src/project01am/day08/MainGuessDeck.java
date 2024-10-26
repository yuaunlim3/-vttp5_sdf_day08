package src.project01am.day08;

import java.io.Console;

public class MainGuessDeck {
    public static void main(String[] args) {
        guessDeck deck = new guessDeck();
        deck.createDeck();
        deck.guess();
        Console cons = System.console();
        System.out.println("Play again (Y/N)");
        String input = cons.readLine(">>>");

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
