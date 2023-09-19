package ru.markina.student.app.domain.id;

class IntIncrementIdProducer implements IdProducer<Integer> {

    /**
     * Класс для задания идентификаторов (студентов, групп, потоков)
     * @param step - шаг изменения (увеличения) идентификатора
     * @param currentId - текущее значение идентификатора
     */
    private final int step;

    private int currentId;

    /**
     * Реализовано 3 конструктора - без параметров с шагом и начальным идентификтатором по умолчанию,
     * с начальным значением и шагом по умолчанию и с обоими параметрами
     */
    public IntIncrementIdProducer() {
        this(1, 1);
    }

    public IntIncrementIdProducer(int start) {
        this(start, 1);
    }
    public IntIncrementIdProducer(int start, int step) {
        this.step = step;
        this.currentId = start;
    }

    /**
     * Реализация метода по автоматическому заданию id
     * @return идентификатор
     */
    @Override
    public Integer nextId() {
        int result = currentId;
        currentId += step;
        return result;
    }
}
