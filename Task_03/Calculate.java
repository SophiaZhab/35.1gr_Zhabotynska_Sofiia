package Task_03;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Клас для виконання розрахунків десяткового, вісімкового та шістнадцяткового представлень чисел.
 */
public class Calculate {

    /** Ім'я файлу для збереження результатів серіалізації. */
    private static final String FNAME = "Item2d.bin";

    /** Об'єкт класу Item2d для представлення результатів розрахунків. */
    private Item2d resultOct;

    /**
     * Конструктор класу Calculate, ініціалізує об'єкт resultOct.
     */
    public Calculate() {
        resultOct = new Item2d();
    }

    /**
     * Метод для встановлення нового значення resultOct.
     *
     * @param resultOct Новий об'єкт Item2d для встановлення.
     */
    public void setResultOct(Item2d resultOct) {
        this.resultOct = resultOct;
    }

    /**
     * Метод для отримання поточного значення resultOct.
     *
     * @return Поточний об'єкт Item2d.
     */
    public Item2d getResultOct() {
        return resultOct;
    }

    /**
     * Приватний метод для розрахунку вісімкового представлення числа.
     *
     * @param decimalValue Десяткове число для розрахунку.
     * @return Кількість цифр у вісімковому представленні числа.
     */
    private int calculateOct(int decimalValue) {
        String octNumInStr = "";
        int decimalLocal = decimalValue;
        int octNumber = 0;

        while (decimalLocal > 0) {
            octNumInStr = decimalLocal % 8 + octNumInStr;
            decimalLocal /= 8;
            octNumber++;
        }

        return octNumber;
    }

    /**
     * Приватний метод для розрахунку шістнадцяткового представлення числа.
     *
     * @param decimalValue Десяткове число для розрахунку.
     * @return Кількість цифр у шістнадцятковому представленні числа.
     */
    private int calculateHex(int decimalValue) {
        String hexNumInStr = "";
        int decimalLocal = decimalValue;
        int hexNumber = 0;

        while (decimalLocal > 0) {
            hexNumInStr = NumberAsLetter(decimalLocal % 16) + hexNumInStr;
            decimalLocal /= 16;
            hexNumber++;
        }

        return hexNumber;
    }

    /**
     * Публічний метод для ініціалізації значень відповідно до десяткового числа.
     *
     * @param decimalValue Десяткове число для ініціалізації.
     * @return Кількість цифр у шістнадцятковому представленні числа.
     */
    public int init(int decimalValue) {
        resultOct.setDecimalValue(decimalValue);
        resultOct.setOctNumber(calculateOct(decimalValue));
        return resultOct.setHexNumber(calculateHex(decimalValue));
    }

    /**
     * Публічний метод для відображення результатів розрахунків.
     */
    public void show() {
        System.out.println(resultOct);
    }

    /**
     * Публічний метод для збереження результатів розрахунків у файл.
     *
     * @throws IOException Виникає у випадку помилки під час серіалізації.
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(resultOct);
        os.flush();
        os.close();
    }

    /**
     * Публічний метод для відновлення результатів розрахунків з файлу.
     *
     * @throws Exception Виникає у випадку помилки під час десеріалізації.
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        resultOct = (Item2d) is.readObject();
        is.close();
    }

    /**
     * Допоміжний метод для перетворення чисел-остач 10, 11, 12, 13, 14 та 15 в їх шістнадцяткове представлення.
     *
     * @param number Цифра для перетворення.
     * @return Шістнадцяткове представлення заданої цифри.
     */
    private String NumberAsLetter(int number) {
        if (number < 10) {
            return Integer.toString(number);
        } else {
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
            }
        }
    }
}