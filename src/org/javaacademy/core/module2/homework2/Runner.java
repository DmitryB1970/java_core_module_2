package org.javaacademy.core.module2.homework2;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {

        ex1();
        ex2();
    }

    public static void ex1() {
        LuggageBelt luggageBelt = new LuggageBelt();
        luggageBelt.luggageUnload("luggage.csv");
    }

    public static void ex2() {

        GroupLuggageByWeight groupLuggageByWeight = new GroupLuggageByWeight();
        System.out.println(groupLuggageByWeight.luggageSort());
    }
}
