package Task_05;

import java.io.IOException;

import Task_0203.View;

/**
 * Консольна команда
 * Save;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class SaveConsoleCommand implements ConsoleCommand {
    private View view;

    /**
     * Ініціалізує поле {@linkplain SaveConsoleCommand#view}
     * 
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'з';
    }

    @Override
    public String toString() {
        return "'з'берегти";
    }

    @Override
    public void execute() {
        System.out.println("Зберігаю поточний.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e);
        }
        view.viewShow();
    }
}
