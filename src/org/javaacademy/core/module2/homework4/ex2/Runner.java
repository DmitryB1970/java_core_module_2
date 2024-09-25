package org.javaacademy.core.module2.homework4.ex2;

//Задание №2 - Сколько здесь "о" ?
//1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
//2. Создать стрим у набора
//2.1 Посчитать количество букв "о" в одном слове
//2.2 Посчитать сумму количества букв "о" во всех словах из набора
//2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
//
//ожидаемый результат:
//6


import java.util.*;

public class Runner {
    public static void main(String[] args) {

        Set<String> uniqWords = new LinkedHashSet<>(List.of("тон", "тополь", "боль", "рой", "стройка"));
        System.out.println(uniqWords.stream().filter(e -> e.contains("о")).count());









        }




}
