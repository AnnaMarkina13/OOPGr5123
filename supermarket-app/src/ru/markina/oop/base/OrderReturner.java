package ru.markina.oop.base;

/**
 * Добавила интерфейс для возврата заказа (аналог iReturnOrder в задании)
 */
public interface OrderReturner {

    /**
     * Метод для возврата заказа
     */
    void returnOrder();

    /**
     * Метод для проверки, не вернули ли заказ ранее
     * @return true, если заказ уже возвращен, иначе - false
     */
    boolean isOrderReturned();
}
