package src;
import java.io.Serializable;

/** Клас для зберігання параметрів і результатів обчислень
*/
public class Item2d implements Serializable{
    private static final long serialVersionUID = 1L;
    /** Аргумент обчислювальної функції. */
    private int decimalValue;
    /** Результат переведення в 8-кову систему обчислення */
    private int octNumber;
    /** Результат переведення в 16-кову систему обчислення */
    private int hexNumber;

    public Item2d() {
        this.decimalValue = 0;
        this.octNumber = 0;
        this.hexNumber = 0;
    }
    /**
     * Конструктор класу `CalculationResult`, який ініціалізує всі поля.
     * @param decimalValue Десяткове значення.
     * @param octNumber Вісімкове значення.
     * @param hexNumber Шістнадцяткове значення.
     */
    public Item2d(int decimalValue, int octNumber, int hexNumber) {
        this.decimalValue = decimalValue;
        this.octNumber = octNumber;
        this.hexNumber = hexNumber;
        }
    public int setDecimalValue(int decimalValue) {
        return this.decimalValue = decimalValue;
    }
    /**
     * Отримання десяткового значення.
     * @return Десяткове значення.
     */
    public int getDecimalValue() {
        return decimalValue;
    }
    public int setOctNumber(int octNumber){
        return this.octNumber = octNumber;
    }
    /**
     * Отримання вісімкового значення.
     * @return Вісімкове значення.
     */
    public int getHexNumber() {
        return hexNumber;
    }

    public int setHexNumber(int hexNumber){
        return this.hexNumber = hexNumber;
    }
    /**
     * Отримання вісімкового значення.
     * @return Вісімкове значення.
     */
    public int getOctNumber() {
        return octNumber;
    }

    public Item2d setDecOctHex(int decimalValue, int octNumber, int hexNumber) {
        this.decimalValue = decimalValue;
        this.octNumber = octNumber;
        this.hexNumber = hexNumber;
        return this;
    }

    public String toString() {
        return "Десяткове число = " + decimalValue + ", кількість цифр у 8-у числі = " + octNumber + ", у 16-у числі = " + hexNumber;
        }

    public boolean equals(Object obj) {
            if (this == obj)
            return true;
            if (obj == null)
            return false;
            if (getClass() != obj.getClass())
            return false;
    
            Item2d other = (Item2d) obj;
            if (Double.doubleToLongBits(decimalValue) != Double.doubleToLongBits(other.decimalValue))
            return false;
            if (Math.abs(Math.abs(octNumber) - Math.abs(other.octNumber)) > 0)
            return false;
            return true;
            }
}