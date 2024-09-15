package org.javaacademy.core.module2.homework2.ex1;

import java.util.Scanner;



public class LuggageUtil {

    private static final int LUGGAGE_NUMBER_INDEX = 0;
    private static final int LUGGAGE_WEIGHT_INDEX = 1;
    private static final String DELIMETER = ";";

    public static Luggage readLineAndDeserializeLuggage(Scanner scanner) {
        String[] row = scanner.nextLine().split(DELIMETER);
        String luggageNumber = row[LUGGAGE_NUMBER_INDEX];
        int luggageWeight = Integer.valueOf(row[LUGGAGE_WEIGHT_INDEX]);
        return new Luggage(luggageNumber, luggageWeight);
    }

    public static void skipFirstLineFromFile(Scanner scanner) {
        if (scanner.hasNext()) {
            scanner.nextLine();
        }
    }
}
