package Task_04;

import java.util.Formatter;
import Task_03.Item2d;
import Task_03.ViewResult;
/**
 * Клас `ViewTable` успадковує клас `ViewResult` та забезпечує функціональність 
 * для відображення таблиці значень у різних системах числення.
 */
public class ViewTable extends ViewResult {
    /**
     * Стала, що визначає ширину таблиці за замовчуванням.
     */
    private static final int DEFAULT_WIDTH = 51;
    private int width;
    /**
     * Конструктор за замовчуванням. Створює об'єкт `ViewTable` із шириною за замовчуванням.
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }
    /**
     * Конструктор, що приймає ширину таблиці як аргумент.
     *
     * @param width Ширина таблиці.
     */
    public ViewTable(int width) {
        this.width = width;
    }
    /**
     * Конструктор, що приймає ширину таблиці та кількість елементів як аргументи.
     *
     * @param width Ширина таблиці.
     * @param n Кількість елементів, які потрібно додати до таблиці.
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }
    /**
     * Метод для встановлення ширини таблиці.
     *
     * @param width Нова ширина таблиці.
     * @return Нова ширина таблиці (по суті, це незмінне значення, тому повернення width є зайвим).
     */
    public int setWidth(int width) {
        return this.width = width;
    }
    /**
     * Метод для отримання ширини таблиці.
     *
     * @return Поточна ширина таблиці.
     */
    public int getWidth() {
        return width;
    }
    /**
     * Допоміжний метод для друку рядка роздільників.
     */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }
    /**
     * Метод для друку рядка роздільників з переходом на новий рядок.
     */
    public void outLineLn() {
        outLine();
        System.out.println();
    }
    /**
     * Метод для друку заголовка таблиці.
     */
    public void outHeader() {
        Formatter fmt = new Formatter();
        int localWidth = (width - 4) / 3;
        fmt.format("%-" + (localWidth - 10) + "s | %-" + localWidth + "s | %s",  "десяткова сис.",  "вісімкова сис.",  "шістнадцяткова");
        System.out.println(fmt);}
    /**
     * Метод для друку тіла таблиці.
     */
    public void outBody() {
        int localWidth = (width - 4) / 3;
        for(Item2d item : getItems()) {
            Formatter fmt = new Formatter();
            fmt.format("%-" + (localWidth - 1) + "d | %-" + localWidth + "s | %s%n", item.getDecimalValue(), item.getOctNumber(), item.getHexNumber());
            System.out.printf(fmt.toString());
        }
    }
    /**
     * Метод для налаштування ширини таблиці та ініціалізації таблиці.
     *
     * @param width Ширина таблиці.
     */
    public final void initWidth(int width) {
        this.width = width;
        viewInit();
    }
    /**
     * Метод для одночасної ініціалізації ширини таблиці та кроку значень у десятковій системі.
     *
     * @param width Ширина таблиці.
     * @param stepdecimalValue Крок значень у
     */
    public final void init(int width, int stepdecimalValue) {
        this.width = width;
        init(stepdecimalValue);
    }

    @Override
    public void init(int stepdecimalValue) {
        System.out.print("Ініціалізація... ");
        super.init(stepdecimalValue);
        System.out.println("готово. ");
    }

    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    @Override
    public void viewBody() {
        outBody();
    }

    @Override
    public void viewFooter() {
        outLineLn();
        }
}
