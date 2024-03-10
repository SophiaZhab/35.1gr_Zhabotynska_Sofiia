package Task_06;

import java.util.concurrent.TimeUnit;
import Task_03.ViewResult;
import Task_05.Command;

/**
 * Клас {@code MaxCommand} реалізує команду для пошуку максимального
 * вісімкового числа серед набору елементів {@code Item2d}.
 * 
 * @author Софія Жаботинська
 */
public class MaxCommand implements Command {
    /**
     * Індекс елемента з максимальним вісімковим числом.
     */
    private int result = -1;
    /**
     * Поточний прогрес виконання команди (у відсотках).
     */
    private int progress = 0;
    /**
     * Об'єкт для доступу до даних.
     */
    private ViewResult viewResult;

    /**
     * Повертає значення поля {@code viewResult}.
     * 
     * @return значення поля {@code viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Встановлює значення поля {@code viewResult}.
     * 
     * @param viewResult нове значення поля {@code viewResult}
     * @return нове значення поля {@code viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Конструктор для {@code MaxCommand}.
     * 
     * @param viewResult об'єкт для доступу до даних
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає індекс елемента з максимальним вісімковим числом.
     * 
     * @return індекс елемента з максимальним вісімковим числом
     */
    public int getResult() {
        return result;
    }

    /**
     * Перевіряє, чи команда все ще виконується.
     * 
     * @return {@code true}, якщо команда виконується, {@code false} інакше
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Виконує пошук максимального вісімкового числа.
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max виконано...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(result).getOctNumber() <= viewResult.getItems().get(idx).getOctNumber()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max закінчено. Item #" + result +

                " знайдений: " + viewResult.getItems().get(result));

        progress = 100;
    }
}
