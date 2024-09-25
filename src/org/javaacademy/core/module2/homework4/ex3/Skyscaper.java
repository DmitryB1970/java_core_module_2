package org.javaacademy.core.module2.homework4.ex3;

public class Skyscaper {

    private String name;
    private int height;

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public Skyscaper(String name, int height) {
        this.name = name;
        this.height = height;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Skyscaper{");
        sb.append("name='").append(name);
        sb.append(", height=").append(height).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
