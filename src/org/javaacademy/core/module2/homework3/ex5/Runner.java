package org.javaacademy.core.module2.homework3.ex5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator - функция сравнения, которая принимает два аргумента и возвращает:
 *  - отрицательное число, если первый объект меньше второго:
 *  - 0 - если объекты равны
 *  - положительное число - если первый объект больше второго.
 */

public class Runner {

    public static void main(String[] args) {

        Feedback feedback1 = new Feedback(1, 145,
                LocalDateTime.of(2023, 5, 11, 12, 45), "то, что надо!");
        Feedback feedback2 = new Feedback(2, 145,
                LocalDateTime.of(2022, 12, 31, 21, 10), "плохой товар!");
        Feedback feedback3 = new Feedback(3, 110,
                LocalDateTime.of(2021, 3, 7, 10, 13), "хороший товар!");
        Feedback feedback4 = new Feedback(4, 1,
                LocalDateTime.of(2024, 2, 17, 14, 17), "плохое качество");
        Feedback feedback5 = new Feedback(5, 80,
                LocalDateTime.of(2020, 6, 12, 19, 33), "можно брать");

        List<Feedback> feedbackList = new ArrayList<>(List.of(feedback1, feedback2, feedback3, feedback4, feedback5));

        Comparator<Feedback> feedbackComparator = (feedbackOne, feedbackTwo) -> {
            int result = 0;
            result = feedbackOne.getLike() - feedbackTwo.getLike();
            if (feedbackOne.getLike() == feedbackTwo.getLike()) {
                result = feedbackOne.getLocalDateTime().compareTo(feedbackTwo.getLocalDateTime());
            } else if (feedbackOne.getLike() == feedbackTwo.getLike()
                    && feedbackOne.getLocalDateTime().equals(feedbackTwo.getLocalDateTime())) {
                result = feedbackOne.getId() - feedbackTwo.getId();
            }
            return result;
        };

        feedbackList.sort(feedbackComparator);
        System.out.println(feedbackList);
    }
}

