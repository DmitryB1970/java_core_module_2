package org.javaacademy.core.module2.homework4.ex3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Runner {

    public static void main(String[] args) {

        List<Skyscaper> skyscapers = new ArrayList<>(List.of(
                new Skyscaper("World Trade Center", 541),
                new Skyscaper("Shanghai Tower", 632),
                new Skyscaper("Burj Khalifa", 828),
                new Skyscaper("Ping An Financial centre", 599),
                new Skyscaper("Abraj Al Bait", 601),
                new Skyscaper("Lotte World Tower", 555),
                new Skyscaper("Burj Khalifa", 828)));

        // Убираем дубликаты
        skyscapers.stream().distinct().forEach(System.out::println);
        System.out.println("_______________________________________");

        //Выводим первые 3 небоскреба
        skyscapers.stream().limit(3).forEach(System.out::println);
        System.out.println("_______________________________________");

        //Самый высокий небоскрёб
        Optional<Skyscaper> max = skyscapers.stream().max(Comparator.comparing(Skyscaper::getHeight));
        max.ifPresent(System.out::println);
        System.out.println("_______________________________________");

        // Небоскребы, которые выше километра
        Optional<Skyscaper> heightMoreThanThousand = skyscapers.stream().filter(e -> e.getHeight() > 1000).findFirst();
        heightMoreThanThousand.ifPresentOrElse(e -> System.out.println(e.getName() + " " + e.getHeight()),
                () -> System.out.println("Небоскреба выше километра - нет"));
    }
}
