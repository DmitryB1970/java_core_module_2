package org.javaacademy.core.module2.homework4.ex1;

import java.util.List;
import java.util.stream.IntStream;
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

    public static final String START_OF_CAR_NUMBER_1 = "а0";
    public static final String END_OF_CAR_NUMBER_1 = "ан799";
    public static final String START_OF_CAR_NUMBER_2 = "к0";
    public static final String END_OF_CAR_NUMBER_2 = "се178";
    public static final int CAR_QUANTITY = 50;
    public static final int START_INDEX = 1;
    public static final int END_INDEX = 3;

    public static void main(String[] args) {
        List<Car> cars1 = carsList(START_OF_CAR_NUMBER_1, END_OF_CAR_NUMBER_1);
        List<Car> cars2 = carsList(START_OF_CAR_NUMBER_2, END_OF_CAR_NUMBER_2);

        Stream.concat(cars1.stream(), cars2.stream())
                .filter(e -> e.getNumber().substring(START_INDEX, END_INDEX).equals("04"))
                .forEach(e -> System.out.println(e.getNumber()));
    }

    private static List<Car> carsList(String beginIteration, String endIteration) {
        List<Car> carList = IntStream.iterate(1, i -> i + 1)
                .limit(CAR_QUANTITY)
                .mapToObj(i -> new Car(beginIteration + i + endIteration))
                .toList();
        return carList;
    }
}

