package src;

import java.io.Serializable;

/** Зберігання параметрів і результатів обчислень
*/
public class CalculationResult implements Serializable{
    private static final long serialVersionUID = 1L;
    /** Аргумент обчислювальної функції. */
    private int decimalValue;
    /** Результат переведення в 8-кову систему обчислення */
    private int octNumber;
    /** Результат переведення в 16-кову систему обчислення */
    private int hexNumber;

    public CalculationResult(int decimalValue, int octNumber, int hexNumber) {
        this.decimalValue = decimalValue;
        this.octNumber = octNumber;
        this.hexNumber = hexNumber;
        }
    public int getDecimalValue() {
        return decimalValue;
    }
    public void setDecimalValue(int decimalValue) {
        if(decimalValue >= 0){
        this.decimalValue = decimalValue;
        }
    }
    
    public int getOctNumber() {
        return octNumber;
    }

    public int getHexNumber() {
        return hexNumber;
    }
}
