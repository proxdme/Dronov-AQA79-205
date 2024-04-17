package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    public static String generateFutureDate(int daysToAdd) {
        // Получаем текущую дату
        LocalDate today = LocalDate.now();

        // Добавляем указанное количество дней к текущей дате
        LocalDate futureDate = today.plusDays(daysToAdd);

        // Форматируем будущую дату в строку с помощью DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String futureDateString = futureDate.format(formatter);

        return futureDateString;
    }
}