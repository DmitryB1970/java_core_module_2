package org.javaacademy.core.module2.homework2;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LuggageBelt {

    private String fileName = "luggage.csv";

    private static final int MAX_LUGGAGE_CAPACITY_ON_LUGGAGE_BELT = 10;
    private static final int LUGGAGE_WEIGHT_INDEX = 1;
    private static final int FIELDS_COUNT = 2;


    public void luggageUnload(String fileName) {

        File file = new File(fileName);
        Queue<String[]> queue = new LinkedList<>();
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(fileName));) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                System.out.println("Начинается загрузка на ленту");
                for (int i = 0; i < MAX_LUGGAGE_CAPACITY_ON_LUGGAGE_BELT; i++) {
                    String text = scanner.nextLine();
                    String[] fields = text.split(";");
                    if (fields.length == FIELDS_COUNT && isNumber(fields[LUGGAGE_WEIGHT_INDEX])) {
                        queue.add(fields);
                    }
                }
                for (String[] q : queue) {                      // для контроля загрузки багажа на ленту
                    System.out.println(Arrays.toString(q));
                }

                System.out.println("Лента загружена, начинается выдача багажа");
                for (int i = 0; i < MAX_LUGGAGE_CAPACITY_ON_LUGGAGE_BELT; i++) {
                    System.out.println((queue.poll())[0] + " - выдан");
                }
                System.out.println("Лента пустая, закончена выдача багажа");
            }
        }
    }

    private boolean isNumber(String text) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(text).find();
    }
}
