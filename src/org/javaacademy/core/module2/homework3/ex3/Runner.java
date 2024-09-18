package org.javaacademy.core.module2.homework3.ex3;

/**
 * Consumer - функция, которая принимает 1 аргумент и ничего не возвращает(может делать какое-то действие)
 */

public class Runner {

    public static void main(String[] args) {

        Uranium uranium = new Uranium();
        Tree tree = new Tree();

        Burning<Uranium> nuclearReactor = burningUranium ->
                System.out.println("Зеленый свет вокруг!");

        Burning<Tree> fire = burningFire ->
                System.out.println("Желто-красный свет вокруг!");

        nuclearReactor.burn(uranium);
        fire.burn(tree);
    }
}
