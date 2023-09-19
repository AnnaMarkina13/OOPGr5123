package ru.markina.student.app.domain.id;

public interface IdProducer<I> {

    /**
     * Интерфейс для задания id
     * 1 метод без реализации
     * 1 дефолтный метод и 2 перегрузки
     */
    I nextId();

    /**
     * @return объект класса, реализующего данный интерфейс
     */
    static IdProducer<Integer> ofInt() {
        return new IntIncrementIdProducer();
    }

    static IdProducer<Integer> ofInt(int start) {
        return new IntIncrementIdProducer(start);
    }

    static IdProducer<Integer> ofInt(int start, int step) {
        return new IntIncrementIdProducer(start, step);
    }
}
