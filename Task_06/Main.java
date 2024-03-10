package Task_06;

import Task_03.View;
import Task_05.ChangeConsoleCommand;
import Task_05.GenerateConsoleCommand;
import Task_05.Menu;
import Task_04.ViewableTable;
import Task_05.ViewConsoleCommand;

/**
 * Основний клас програми.
 *
 * @author Софія Жаботинська
 */
public class Main {
    /**
     * Об'єкт для візуалізації даних.
     */
    private View view = new ViewableTable().getView();
    /**
     * Об'єкт головного меню.
     */
    private Menu menu = new Menu();

    /**
     * Запускає програму.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
