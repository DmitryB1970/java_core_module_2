package org.javaacademy.core.module2.homework2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GroupLuggageByWeight {

    private String fileName = "luggage.csv";

    private static final int LUGGAGE_WEIGHT_INDEX = 1;
    private static final int FIELDS_COUNT = 2;

    public Map<String, Integer> luggageSort() {
        File file = new File(fileName);
        Map<String, Integer> luggageCategoryWeight = new HashMap<>();
        int lightLuggageWeight = 0;
        int middleLuggageWeight = 0;
        int heavyLuggageWeight = 0;
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(fileName));) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                String[] fields = text.split(";");
                if (fields.length == FIELDS_COUNT && isNumber(fields[LUGGAGE_WEIGHT_INDEX])) {
                    if (Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]) < 5) {
                        lightLuggageWeight += Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]);
                    } else if (Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]) >= 5
                            && Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]) < 10) {
                        middleLuggageWeight += Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]);
                    } else {
                        heavyLuggageWeight += Integer.parseInt(fields[LUGGAGE_WEIGHT_INDEX]);
                    }
                }
            }
        }
        luggageCategoryWeight.put("легкий", lightLuggageWeight);
        luggageCategoryWeight.put("средний", middleLuggageWeight);
        luggageCategoryWeight.put("тяжёлый", heavyLuggageWeight);
        return luggageCategoryWeight;
    }

    private boolean isNumber(String text) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(text).find();
    }
}
