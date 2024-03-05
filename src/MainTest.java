package src;
/**
 * Клас для тестування коректності результатів обчислень та
 * серіалізації/десеріалізації.
 */
public class MainTest {
    public static void main(String[] args) {
        Calculate calculator = new Calculate();
        CalculationResult result = calculator.calculate(1765);

        // Вивід результатів обчислень
        System.out.println("Значення десяткового числа: " + result.getDecimalValue());
        System.out.println("8-х цифр: " + result.getOctNumber());
        System.out.println("16-х цифр: " + result.getHexNumber());
    }
}