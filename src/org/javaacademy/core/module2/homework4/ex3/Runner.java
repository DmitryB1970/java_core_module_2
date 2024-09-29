package org.javaacademy.core.module2.homework4.ex3;

import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Skyscaper> skyscapers = List.of(
                new Skyscaper("World Trade Center", 541),
                new Skyscaper("Shanghai Tower", 632),
                new Skyscaper("Burj Khalifa", 828),
                new Skyscaper("Burj Khalifa", 828),
                new Skyscaper("Ping An Financial centre", 599),
                new Skyscaper("Abraj Al Bait", 601),
                new Skyscaper("Lotte World Tower", 555)
        );

        // Убираем дубликаты
        List<Skyscaper> skyscaperListWithoutDuplicates = skyscapers.stream().distinct().toList();
        System.out.println(skyscaperListWithoutDuplicates);
        System.out.println("_______________________________________");

        //Выводим первые 3 небоскреба
        skyscaperListWithoutDuplicates.stream()
                .limit(3).
                forEach(System.out::println);
        System.out.println("_______________________________________");

        //Самый высокий небоскрёб
        skyscaperListWithoutDuplicates.stream()
                .max(Comparator.comparing(Skyscaper::getHeight))
                .ifPresent(System.out::println);
        System.out.println("_______________________________________");

        // Небоскребы, которые выше километра
        skyscapers.stream()
                .filter(e -> e.getHeight() > 1000)
                .peek(System.out::println)
                .toList()
                .stream()
                .findAny()
                .ifPresentOrElse((skyscaper -> {
                }), () -> System.out.println("Небоскреба выше километра - нет"));
    }
}
