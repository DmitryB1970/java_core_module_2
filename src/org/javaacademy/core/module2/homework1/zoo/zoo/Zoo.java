package org.javaacademy.core.module2.homework1.zoo.zoo;

import org.javaacademy.core.module2.homework1.zoo.animal.Animal;

public class Zoo<A1 extends Animal, A2 extends Animal, A3 extends Animal> {

    private A1 animal1;
    private A2 animal2;
    private A3 animal3;

    public A1 getAnimal1() {
        return animal1;
    }

    public A2 getAnimal2() {
        return animal2;
    }

    public A3 getAnimal3() {
        return animal3;
    }

    public Zoo(A1 animal1, A2 animal2, A3 animal3) {
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.animal3 = animal3;
    }
}
