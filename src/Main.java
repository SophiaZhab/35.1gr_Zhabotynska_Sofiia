package src;

import java.io.*;

/**
 * Клас для демонстрації серіалізації та десеріалізації CalculationResult.
 */
public class Main {
    public static void main(String[] args) {
        Calculate calculator = new Calculate();
        CalculationResult result = calculator.calculate(12345);

        // Серіалізація об'єкта
        serializeObject(result, "calculation_result.ser");

        // Відновлення об'єкта з серіалізованого файлу
        CalculationResult restoredResult = deserializeObject("calculation_result.ser");

        // Демонстрація результатів
        System.out.println("Original Result: " + result.getDecimalValue() +
                ", Octal Count: " + result.getOctNumber() +
                ", Hex Count: " + result.getHexNumber());
        System.out.println("Restored Result: " + restoredResult.getDecimalValue() +
                ", Octal Count: " + restoredResult.getOctNumber() +
                ", Hex Count: " + restoredResult.getHexNumber());
    }

    private static void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CalculationResult deserializeObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CalculationResult) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}