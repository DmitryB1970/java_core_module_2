package org.javaacademy.core.module2.homework2.ex2;

import org.javaacademy.core.module2.homework2.ex1.Luggage;
import org.javaacademy.core.module2.homework2.ex1.LuggageUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.javaacademy.core.module2.homework2.ex1.LuggageUtil.readLineAndDeserializeLuggage;
import static org.javaacademy.core.module2.homework2.ex1.LuggageUtil.skipFirstLineFromFile;
import static org.javaacademy.core.module2.homework2.ex2.LuggageCategory.*;


public class Runner {

    public static void main(String[] args) {
        System.out.println(getStatisticsByWeight("luggage.csv"));
    }


    private static Map<String, Integer> getStatisticsByWeight(String filename) {
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream("luggage.csv"))) {
            skipFirstLineFromFile(scanner);
            return getStatisticsByWeight(scanner);
        }
    }

    private static Map<String, Integer> getStatisticsByWeight(Scanner scanner) {
        HashMap<String, Integer> result = new HashMap<>();
        while (scanner.hasNext()) {
            Luggage luggage = readLineAndDeserializeLuggage(scanner);
            addWeightToResultMap(result, luggage);
        }
        return result;
    }

    private static void addWeightToResultMap(Map<String, Integer> result, Luggage luggage) {
        int luggageWeight = luggage.getWeight();
        if (luggageWeight < LIGHT.getMaxLimit()) {
            result.put(LIGHT.getName(), result.getOrDefault(LIGHT.getName(), 0) + luggageWeight);
        } else if (luggageWeight < MIDDLE.getMaxLimit()) {
            result.put(MIDDLE.getName(), result.getOrDefault(MIDDLE.getName(), 0) + luggageWeight);
        } else {
            result.put(HEAVY.getName(), result.getOrDefault(HEAVY.getName(), 0) + luggageWeight);
        }
    }
}


