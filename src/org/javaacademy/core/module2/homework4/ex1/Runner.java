package org.javaacademy.core.module2.homework4.ex1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Runner {

    //ИСПОЛЬЗОВАНИЕ FOR, WHILE ЗАПРЕЩЕНО В ЭТОЙ ДЗ! Только СТРИМЫ.

    //Задание №1 - Список спец номеров
    //Нам необходимо распечатать список номеров, которые принадлежат чиновникам
    //1. Создать класс машина. У машины есть номер.
    //2. Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
    //3. Создать 50 машин с номерами к0[01-50]се178 (где [01-50] - это все значения от 01 до 50)
    //4. Объединить машины в единый стрим
    //5. Оставить в объединенном стриме машины с номерами 04[0-9] - это номера, выдаваемые чиновникам
    //6. Получить из оставшихся машин номера.
    //7. Распечатать номера.
    //ожидаемый результат:
    // a040ан799
    // a041ан799
    // ...
    // k048се178
    // k049се178


    private static final int COUNT_NUMBERS_IN_CAR_NUMBERS = 3;
    private static final String FIRST_CAR_NUMBER_PATTERN = "а%sан799";
    private static final String SECOND_CAR_NUMBER_PATTERN = "к%sсе178";
    private static final int COUNT_CARS = 50;
    private static final int CAR_NUMBER_STAR_INDEX = 1;
    private static final int CAR_NUMBER_END_INDEX = 4;
    private static final int LOWER_INDEX_GOVERNMENT_NUMBER = 40;
    private static final int UPPER_LIMIT_GOVERNMENT_NUMBER = 49;


    public static void main(String[] args) {

        Stream<Car> firstCarStream = generateCars(FIRST_CAR_NUMBER_PATTERN, COUNT_CARS);
        Stream<Car> secondCarStream = generateCars(SECOND_CAR_NUMBER_PATTERN, COUNT_CARS);
        Stream.concat(firstCarStream, secondCarStream)
                .filter(car -> isGovernmentEmployeeNumber(car.getNumber()))
                .map(Car::getNumber)
                .forEach(System.out::println);
    }

    private static boolean isGovernmentEmployeeNumber(String number) {
        Integer carNumber = Integer.valueOf(number.substring(CAR_NUMBER_STAR_INDEX, CAR_NUMBER_END_INDEX));
        return carNumber >= LOWER_INDEX_GOVERNMENT_NUMBER && carNumber <= UPPER_LIMIT_GOVERNMENT_NUMBER;
    }

    public static Stream<Car> generateCars(String numberPattern, int countCars) {

        AtomicInteger carNumber = new AtomicInteger(0);
        return Stream.generate(() -> new Car(createNumber(numberPattern, carNumber.addAndGet(1))))
                .limit(countCars);
    }

    public static String createNumber(String numberPattern, Integer number) {
        String textNumber = "0".repeat(COUNT_NUMBERS_IN_CAR_NUMBERS - number.toString().length())
                .concat(number.toString());
        return numberPattern.formatted(textNumber);
    }
}
