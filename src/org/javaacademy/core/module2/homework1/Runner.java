package org.javaacademy.homework.homework1;

import org.javaacademy.core.module2.homework1.zoo.animal.Bird;
import org.javaacademy.core.module2.homework1.zoo.animal.Dog;
import org.javaacademy.core.module2.homework1.zoo.animal.Tiger;
import org.javaacademy.core.module2.homework1.zoo.zoo.Zoo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        ex1();
        System.out.println("---------------------------------------------------");
        ex2();
        System.out.println("---------------------------------------------------");
        ex3();
    }

    public static void ex1() {

        Zoo<Tiger, Dog, Bird> animals = new Zoo<>(new Tiger(), new Dog(), new Bird());

        animals.getAnimal1().roar();
        animals.getAnimal2().bark();
        animals.getAnimal3().canFly();
    }

    public static void ex2() {

        List<Integer> januaryTemperatures = List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10,
                -5, -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1);
        List<Integer> februaryTemperatures = List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8,
                -10, -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1);
        List<Integer> twoListTemperatures = new ArrayList<>(januaryTemperatures);
        twoListTemperatures.addAll(februaryTemperatures);

        BigDecimal resultTemperature = BigDecimal.ZERO;

        for (Integer temperature : twoListTemperatures) {
            resultTemperature = resultTemperature.add(BigDecimal.valueOf(temperature));
        }
        System.out.println("Сумма всех значений температур за два месяца : " + resultTemperature +
                "\nобщее количество значений температур: " + twoListTemperatures.size() +
                "\nсредняя температура за два месяца : " +
                resultTemperature.divide(BigDecimal.valueOf(twoListTemperatures.size()), 2,
                        RoundingMode.HALF_DOWN));
    }

    public static void ex3() {

        List<String> monday = List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо");
        List<String> tuesday = List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон",
                "Реберная");
        List<String> wednesday = List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим");
        List<String> thursday = List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо");
        List<String> friday = List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька");

        List<String> result = new ArrayList<>(monday);
        List<List<String>> days = List.of(monday, tuesday, wednesday, thursday, friday);

        for (List<String> day : days) {
            result.retainAll(day);
        }

        System.out.println("Ресторан, в котором Николай Петрович был каждый день: " + result);
    }
}


