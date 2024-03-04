package src;

public class Calculate {
    public CalculationResult calculate(int decimalValue) {
        String hexNumInStr = "";
        int decimalLocal = decimalValue;
        int hexNumber = 0;
        while (decimalLocal > 0) {
            hexNumInStr = decimalLocal % 8 + hexNumInStr;
            decimalLocal /=8;
            hexNumber++;
        }

        String octNumInStr = "";
        decimalLocal = decimalValue;
        int octNumber = 0;
        while (decimalLocal > 0) {
            octNumInStr = NumberAsLetter(decimalLocal % 16) + octNumInStr;
            decimalLocal /=16;
            octNumber++;
        }
    return new CalculationResult(decimalValue, hexNumber, octNumber);
    }

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

