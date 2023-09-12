package ru.markina.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения информации об акционных клиентах, их максимально возможном количестве
 * Поле maxSize - максимальное количество участников акции
 * Список clients - список для хранения акционных клиентов
 */
public class PromotionalClientsHolder {

    private final int maxSize;

    private final List<PromotionalClient> clients = new ArrayList<>();

    public PromotionalClientsHolder(final int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Метод для заполнения списка акционных клиентов,
     * при этом при превышении количества участников акции клиенту отказывается в обслуживании
     *
     * @param - акционный клиент
     * @return объект данного класса
     */
    public PromotionalClientsHolder addPromotionalClient(PromotionalClient client) {
        if (clients.size() < maxSize) {
            this.clients.add(client);
        } else {
            System.out.printf("Клиенту с идентификатором = %s отказано в обслуживании\n", client.getId().toString());
        }
        return this;
    }

    /**
     *
     * @return количество акционных клиентов на момент вызова метода
     */
    public int getSize() {
        return clients.size();
    }

    /**
     * геттер для maxSize
     * @return maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * геттер для списка акционных клиентов
     */
    public List<PromotionalClient> getClients() {
        return clients.stream().toList();
    }
}
