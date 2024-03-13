package Task_05;

import Task_0203.View;

/**
 * Консольна команда
 * Restore;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class RestoreConsoleCommand implements ConsoleCommand {
    private View view;

    /**
     * Ініціалізує поле {@linkplain RestoreConsoleCommand#view}
     * 
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'в';
    }

    @Override
    public String toString() {
        return "'в'ідновити";
    }

    @Override
    public void execute() {
        System.out.println("Відновлюю останній збережений запис.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Помилка серіалізації: " + e);
        }
        view.viewShow();
    }
}
