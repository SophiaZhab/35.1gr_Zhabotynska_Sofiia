package Task_05;

import Task_0203.View;
import Task_04.ViewableTable;

/**
 * Формує та відображає
 * меню; реалізує шаблон
 */
public class Application {
    /**
     * Посилання на екземпляр класу Application; шаблон Singleton
     * 
     * @see Application
     */
    private static Application instance = new Application();

    /**
     * Закритий конструктор; шаблон Singleton
     * 
     * @see Application
     */
    private Application() {
    }

    /**
     * Повертає посилання на екземпляр класу Application;
     * шаблон Singleton
     * 
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }

    private View view = new ViewableTable().getView();

    private Menu menu = new Menu();

    /**
     * Обробка команд користувача
     * 
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));

        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}
