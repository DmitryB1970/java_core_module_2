package org.javaacademy.core.module2.homework4.ex1;

public class Car {

    private String number;

    public Car(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
