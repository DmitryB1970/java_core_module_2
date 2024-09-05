package org.javaacademy.homework.homework1;

import org.javaacademy.core.module2.homework1.zoo.animal.Animal;
import org.javaacademy.core.module2.homework1.zoo.animal.Bird;
import org.javaacademy.core.module2.homework1.zoo.animal.Dog;
import org.javaacademy.core.module2.homework1.zoo.animal.Tiger;
import org.javaacademy.core.module2.homework1.zoo.zoo.Zoo;

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

        Zoo<Animal> animals = new Zoo<>(new Tiger(), new Dog(), new Bird());

        ((Tiger) animals.getAnimal1()).roar();
        ((Dog)animals.getAnimal2()).bark();
        ((Bird)animals.getAnimal3()).canFly();
    }

    public static void ex2() {

        List<Integer> januaryTemperatures = new ArrayList<>(List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10,
                -5, -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1));
        List<Integer> februaryTemperatures = new ArrayList<>(List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8,
                -10, -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1));
        List<Integer> twoListTemperatures = new ArrayList<>();
        twoListTemperatures.addAll(januaryTemperatures);
        twoListTemperatures.addAll(februaryTemperatures);

        int sum = 0;
        int count = 0;
        for (Integer temperature : twoListTemperatures) {
            sum += temperature;
            count++;
        }
        System.out.printf("Сумма всех значений температур за два месяца: %d\nобщее количество значений температур: " +
                "%d\nсредняя температура за два месяца: %.2f\n", sum, count, (double) sum / count);
    }

    public static void ex3() {

        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон",
                "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        monday.retainAll(tuesday);
        monday.retainAll(wednesday);
        monday.retainAll(thursday);
        monday.retainAll(friday);
        System.out.println("Ресторан, в котором Николай Петрович был каждый день: " + monday);
    }
}


