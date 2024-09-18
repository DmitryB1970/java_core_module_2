package org.javaacademy.core.module2.homework3.ex2;

/**
 * Predicate - функция, которая принимает 1 аргумент и возвращает true/false
 */

public class Runner {

    public static void main(String[] args) {
        Human human1 = new Human(180, 35);
        Human human2 = new Human(150, 25);
        String name1 = "Вася";
        String name2 = "Алекс";

        Divination<String> chamomile = name -> name.length() % 2 == 0;
        Divination<Human> grannyFortuneTeller = human -> (human.getAge() + human.getHeight()) > 210;

        System.out.println(chamomile.answer(name1));
        System.out.println(grannyFortuneTeller.answer(human1));
    }
}
