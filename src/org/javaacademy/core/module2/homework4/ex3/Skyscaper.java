package org.javaacademy.core.module2.homework4.ex3;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skyscaper skyscaper = (Skyscaper) o;
        return height == skyscaper.height && Objects.equals(name, skyscaper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
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
