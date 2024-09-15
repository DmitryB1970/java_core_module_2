package org.javaacademy.core.module2.homework2.ex1;

import java.util.LinkedList;
import java.util.Scanner;

public class Runner {

    private static final int LUGGAGE_TAPE_LIMIT_SIZE = 10;

    public static void main(String[] args) {
        unloadBaggage("luggage.csv");
    }

    private static void unloadBaggage(String filename) {
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(filename))) {
            LuggageUtil.skipFirstLineFromFile(scanner);
            unloadBaggage(scanner);
        }
    }

    private static void unloadBaggage(Scanner scanner) {
        LinkedList<Luggage> luggageTape = new LinkedList<>();
        while (scanner.hasNext()) {
            loadOnTapeByPortion(scanner, luggageTape, LUGGAGE_TAPE_LIMIT_SIZE);
            System.out.println("Лента загружена, начинается выдача багажа");
            unloadTape(luggageTape);
        }
    }

    /**
     * Загрузка на багажную ленту порциями по n штук
     */

    private static void loadOnTapeByPortion(Scanner scanner, LinkedList<Luggage> luggageTape, int portion) {
        System.out.println("Начинается загрузка на ленту");
        while (luggageTape.size() < (portion + 1) && scanner.hasNext()) {
            Luggage luggage = LuggageUtil.readLineAndDeserializeLuggage(scanner);
            luggageTape.add(luggage);
        }
    }

    private static void unloadTape(LinkedList<Luggage> luggageTape) {
        while (luggageTape.size() > 0) {
            Luggage luggage = luggageTape.poll();
            System.out.printf("%s - выдан\n", luggage.getNumber());
        }
        System.out.println("Лента пустая, закончена выдача багажа");
    }
}
