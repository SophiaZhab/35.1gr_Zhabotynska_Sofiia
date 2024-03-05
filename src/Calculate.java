package src;
/**
 * Клас для виконання розрахунків десяткового, вісімкового та шістнадцяткового представлень чисел.
 */
public class Calculate {
    public CalculationResult calculate(int decimalValue) {
        // Розрахунок вісімкового представлення
        String octNumInStr = "";
        int decimalLocal = decimalValue;
        int octNumber = 0;
        while (decimalLocal > 0) {
            octNumInStr = decimalLocal % 8 + octNumInStr;
            decimalLocal /=8;
            octNumber++;
        }
        // Розрахунок шістнадцяткового представлення
        String hexNumInStr = "";
        decimalLocal = decimalValue;
        int hexNumber = 0;
        while (decimalLocal > 0) {
            hexNumInStr = NumberAsLetter(decimalLocal % 16) + hexNumInStr;
            decimalLocal /=16;
            hexNumber++;
        }
    return new CalculationResult(decimalValue, hexNumber, octNumber);
    }
    /**
     * Допоміжний метод для перетворення чисел-остач 10, 11, 12, 13, 14 та 15 в їх шістнадцяткове представлення.
     *
     * @param number Цифра для перетворення.
     * @return Шістнадцяткове представлення заданої цифри.
     */
        private String NumberAsLetter(int number){
            if(number < 10) {return Integer.toString(number);}
            else{
            switch (number) {
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
                default:
                    return " ";
            }}
        }
    }

