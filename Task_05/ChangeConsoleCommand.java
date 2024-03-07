package Task_05;

import Task_03.Item2d;
import Task_03.View;
import Task_03.ViewResult;

/**
 * Консольна команда
 * Change item;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class ChangeConsoleCommand extends ChangeItemCommand implements ConsoleCommand {

    private View view;

    /**
     * Повертає поле {@linkplain ChangeConsoleCommand#view}
     * 
     * @return значення {@linkplain ChangeConsoleCommand#view}
     */
    public View getView() {
        return view;
    }

    /**
     * Встановлює поле {@linkplain ChangeConsoleCommand#view}
     * 
     * @param view значення для {@linkplain ChangeConsoleCommand#view}
     * @return нове значення {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
    }

    /**
     * Ініціалізує поле {@linkplain ChangeConsoleCommand#view}
     * 
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'м';
    }

    @Override
    public String toString() {
        return "'м'інити";
    }

    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset((int) Math.random() * 100));
        for (Item2d item : ((ViewResult) view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}
