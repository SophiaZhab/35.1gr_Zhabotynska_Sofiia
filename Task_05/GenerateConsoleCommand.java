package Task_05;

import Task_03.View;

/**
 * Консольна команда
 * Generate;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    private View view;

    /**
     * Ініціалізує поле {@linkplain GenerateConsoleCommand#view}
     * 
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'г';
    }

    @Override
    public String toString() {
        return "'г'енерувати";
    }

    @Override
    public void execute() {
        System.out.println("Випадкова генерація.");
        view.viewInit();
        view.viewShow();
    }
}
