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
        System.out.println("Decimal Value: " + result.getDecimalValue());
        System.out.println("Octal Count: " + result.getOctNumber());
        System.out.println("Hex Count: " + result.getHexNumber());
    }
}