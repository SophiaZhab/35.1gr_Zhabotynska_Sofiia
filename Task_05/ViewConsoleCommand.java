package Task_05;

import Task_03.View;

/**
 * Консольна команда
 * View;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class ViewConsoleCommand implements ConsoleCommand {
    private View view;

    /**
     * Ініціалізує поле {@linkplain SaveConsoleCommand#view}
     * 
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'п';
    }

    @Override
    public String toString() {
        return "'п'оказати";
    }

    @Override
    public void execute() {
        System.out.println("Показую поточний.");
        view.viewShow();
    }
}
