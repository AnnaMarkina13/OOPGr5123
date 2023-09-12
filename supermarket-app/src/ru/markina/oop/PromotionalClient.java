package ru.markina.oop;

import ru.markina.oop.base.AbstractActor;

/**
 * Класс для акционного клиента, расширяет класс AbstractActor
 * Поле promotionName - название акции (+ геттер и сеттер)
 */
public class PromotionalClient extends AbstractActor {
    private String promotionName;

    public PromotionalClient(String name, String promotionName) {
        super(name);
        this.promotionName = promotionName;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(final String promotionName) {
        this.promotionName = promotionName;
    }
}
