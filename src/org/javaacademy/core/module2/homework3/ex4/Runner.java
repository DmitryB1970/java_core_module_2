package org.javaacademy.core.module2.homework3.ex4;

/**
 * Function - функция, которая принимает 1 аргумент и возвращает указанный тип данных
 */

public class Runner {

    public static void main(String[] args) {

        Boat boat = new Boat(10);
        Animal animal = new Animal(5, 2);

        Ruler<Boat> boatRuler = ship -> ship.getLength();
        Ruler<Animal> animalRuler = beast -> beast.getBodyLength() + beast.getTailLength();

        System.out.println(boatRuler.ruler(boat));
        System.out.println(animalRuler.ruler(animal));
    }
}
