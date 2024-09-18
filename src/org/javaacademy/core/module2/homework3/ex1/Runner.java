package org.javaacademy.core.module2.homework3.ex1;

/**
 * Supplier - функция, которая не принимает аргумент и возвращает указанный тип данных
 */

public class Runner {

    public static void main(String[] args) {
        Garden<Apple> appleFarm = () -> new Apple();
        Garden<Apricot> apricotFarm = () -> new Apricot();
        Fruit apple = appleFarm.grow();
        Fruit apricot = apricotFarm.grow();
    }
}
