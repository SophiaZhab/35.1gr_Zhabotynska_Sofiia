package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import java.io.IOException;
import src.Calculate;

public class MainTest {
    @Test
    public void testCalculate() {
        Calculate calc = new Calculate();
            calc.init(0);
            int[] expected = {1, 2};
            int[] actual = new int[2];
            actual[0] = calc.getResultOct().getOctNumber();
            actual[1] = calc.getResultOct().getHexNumber();
            assertEquals(expected, actual);
    }

    @Test
    public void testRestore() {
        Calculate calc = new Calculate();
        int decimalValue, octNumber;
        for (int ctr = 0; ctr < 100000; ctr++) {
            decimalValue = (int) (Math.round(Math.random() * 100000));
            octNumber = calc.init(decimalValue);
            try {
                calc.save();
            } catch (IOException e) {
                assertEquals(e.getMessage(), ""); // Змінено імпорт
            }
            calc.init((int)Math.random() * 100000);
            try {
                calc.restore();
            } catch (Exception e) {
                assertEquals(e.getMessage(), ""); // Змінено імпорт
            }
            assertEquals(octNumber, calc.getResultOct().getOctNumber(), 0);
            assertEquals(decimalValue, calc.getResultOct().getOctNumber(), 0);
        }
    }
}