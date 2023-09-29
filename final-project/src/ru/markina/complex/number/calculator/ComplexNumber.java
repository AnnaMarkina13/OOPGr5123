package ru.markina.complex.number.calculator;

/**
 * Класс - комплексное число
 * @param real реальная часть числа
 * @param image мнимая часть
 */
public record ComplexNumber(double real, double image) {

    @Override
    public String toString() {
        String result;
        if (real == 0) {
            if (image == 0) {
                result = "0";
            } else {
                result = String.valueOf(image);
            }
        } else if (image == 0) {
            result = real + "i";
        } else {
            result = image > 0 ? String.format("%.2fi + %.2f", real, image) : String.format("%.2fi - %.2f", real, -image);
        }
        return result;
    }
}

