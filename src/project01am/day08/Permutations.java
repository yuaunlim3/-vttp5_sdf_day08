package src.project01am.day08;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        Console cons = System.console();
        String input = cons.readLine(">>> ");
        String[] inputs = input.split("");

        Set<String> result = getPermutations(inputs,inputs.length);

        result.forEach(permuations -> {
            System.out.println(permuations);
        });
        System.out.printf("Total number of permuations: %d\n",result.size());

    }

    public static Set<String> getPermutations(String[] input, int numDigits) {
        Set<String> result = new HashSet<>();
        if (numDigits == 1) {
            for (String item : input) {
                result.add(item);
            }
        } else if (input.length > 1) {
            Set<String> temp = getPermutations(input, numDigits - 1);
            for (String item : input) {
                for (String permutations : temp) {
                    if (!permutations.contains(item)) {
                        result.add(item + permutations);
                    }
                }
            }

        }
        return result;
    }
}
