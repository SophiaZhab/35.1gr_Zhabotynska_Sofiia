package src;

import java.io.*;

/**
 * Клас для демонстрації серіалізації та десеріалізації CalculationResult.
 */
public class Main {
    public static void main(String[] args) {
        /**
        * Об'єкт класу Calculate для виконання розрахунків.
        */
        Calculate calculator = new Calculate();
        /**
        * Результат розрахунку, що містить десяткове, вісімкове та шістнадцяткове значення.
        */
        CalculationResult result = calculator.calculate(12345);

        // Серіалізація об'єкта
        serializeObject(result, "calculation_result.ser");

        // Відновлення об'єкта з серіалізованого файлу
        CalculationResult restoredResult = deserializeObject("calculation_result.ser");

        // Демонстрація результатів
        System.out.println("Original Result: " + result.getDecimalValue() +
                ", 8-х цифр: " + result.getOctNumber() +
                ", 16-х цифр: " + result.getHexNumber());
        System.out.println("Restored Result: " + restoredResult.getDecimalValue() +
                ", 8-х цифр: " + restoredResult.getOctNumber() +
                ", 16-х цифр: " + restoredResult.getHexNumber());
    }
    /**
    * Серіалізує об'єкт CalculationResult у файл.
    * @param obj Об'єкт для серіалізації.
    * @param fileName Назва файлу для серіалізації.
    */
    private static void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Об'єкт успішно серіалізувався.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * Десеріалізує об'єкт CalculationResult з файлу.
    * @param fileName Назва файлу з серіалізованим об'єктом.
    * @return Десеріалізований об'єкт CalculationResult.
    */
    private static CalculationResult deserializeObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CalculationResult) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}