package ru.markina.student.app.domain;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Утилитный класс с реализацией компаратора для Person и его наследников
 *
 * Не стала создавать класс, реализовывающий интерфейс Comparator, так как Comparator - функциональный интерфейс, который
 * нет необходимости реализовывать с Java 1.8, так как лямбда - производительнее и эффективнее
 */

public final class PersonComparators {

    /**
     * Приватный конструктор для того, чтобы не дать возможность проинициализировать через new
     */
    private PersonComparators() {
    }

    /**
     * Дефолтный компаратор для сравнения по имени
     * @return объект-компаратор
     */
    public static Comparator<Person> personByNameComparator() {
        return Comparator.comparing(Person::getName);
    }

    /**
     * Метод компаратор для сравнения Person по любым полям
     * @param keyExtractor - признак, по которому сравниваем, должен реализовывать интерфейс Comparable
     * @return объект-компаратор
     * @param <K> - тип ключа, полуаемого из keyExtractor
     */
    public static <T extends Person, K extends Comparable<? super K>> Comparator<T> personComparator(Function<T, K> keyExtractor) {
        return Comparator.comparing(keyExtractor);
    }
}
