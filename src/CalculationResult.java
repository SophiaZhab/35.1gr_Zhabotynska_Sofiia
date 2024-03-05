package src;

import java.io.Serializable;

/** Клас для зберігання параметрів і результатів обчислень
*/
public class CalculationResult implements Serializable{
    private static final long serialVersionUID = 1L;
    /** Аргумент обчислювальної функції. */
    private int decimalValue;
    /** Результат переведення в 8-кову систему обчислення */
    private int octNumber;
    /** Результат переведення в 16-кову систему обчислення */
    private int hexNumber;
    /**
     * Конструктор класу `CalculationResult`, який ініціалізує всі поля.
     * @param decimalValue Десяткове значення.
     * @param octNumber Вісімкове значення.
     * @param hexNumber Шістнадцяткове значення.
     */
    public CalculationResult(int decimalValue, int octNumber, int hexNumber) {
        this.decimalValue = decimalValue;
        this.octNumber = octNumber;
        this.hexNumber = hexNumber;
        }
    /**
     * Отримання десяткового значення.
     * @return Десяткове значення.
     */
    public int getDecimalValue() {
        return decimalValue;
    }
    /**
     * Отримання вісімкового значення.
     * @return Вісімкове значення.
     */
    public int getOctNumber() {
        return octNumber;
    }
    /**
     * Отримання шістнадцяткового значення.
     * @return Шістнадцяткове значення.
     */
    public int getHexNumber() {
        return hexNumber;
    }
}
