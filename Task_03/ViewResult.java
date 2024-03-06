package Task_03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Клас для представлення результатів розрахунків.
 *
 * Містить функціональність для:
 * - ініціалізації даних
 * - збереження даних у файл
 * - відновлення даних з файлу
 * - відображення результатів
 */
public class ViewResult implements View {
    /**
     * Ім'я файлу для збереження/відновлення даних.
     */
    private static final String FNAME = "items.bin";

    private static final int DEFAULT_NUM = 10;

    private ArrayList<Item2d> items = new ArrayList<Item2d>();

    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Створює екземпляр класу із заданою кількістю елементів.
     *
     * @param n кількість елементів для розрахунку
     */
    public ViewResult(int n) {
        for (int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /**
     * Повертає колекцію об'єктів Item2d з результатами розрахунків.
     *
     * @return колекція об'єктів Item2d
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    private int calculateOct(int decimalValue) {
        String octNumInStr = "";
        int decimalLocal = decimalValue;
        int octNumber = 0;

        do {
            octNumInStr = decimalLocal % 8 + octNumInStr;
            decimalLocal /= 8;
            octNumber++;
        } while (decimalLocal > 0);

        return octNumber;
    }

    private int calculateHex(int decimalValue) {
        String hexNumInStr = "";
        int decimalLocal = decimalValue;
        int hexNumber = 0;

        do {
            hexNumInStr = NumberAsLetter(decimalLocal % 16) + hexNumInStr;
            decimalLocal /= 16;
            hexNumber++;
        } while (decimalLocal > 0);

        return hexNumber;
    }

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
    /**
    * Ініціалізує елементи колекції {@link #items}.
    *
    * @param stepdecimalValue крок зміни десяткового значення для наступних елементів
    */
    public void init(int stepdecimalValue) {
        int decimalLocal = 0;
        for (Item2d item : items) {
            item.setDecOctHex(decimalLocal, calculateOct(decimalLocal), calculateHex(decimalLocal));
            decimalLocal += stepdecimalValue;
        }
    }
    /**
    * Реалізує метод {@link View#viewInit()} шляхом виклику методу {@link #init(int)}
    * з випадковим кроком зміни десяткового значення в межах 100000.
    */
    @Override
    public void viewInit() {
        init((int) Math.random() * 100000);
    }
    /**
    * Реалізує метод {@link View#viewSave()} для збереження колекції {@link #items} у файл.
    *
    * @throws IOException якщо виникає помилка під час збереження у файл
    */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    /**
    * Реалізує метод {@link View#viewRestore()} для відновлення колекції {@link #items} з файлу.
    *
    * @throws Exception якщо виникає помилка під час читання з файлу
    */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.format("(%d; %d; %d) ", item.getDecimalValue(), item.getOctNumber(), item.getOctNumber());
        }
        System.out.println();
    }

    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
