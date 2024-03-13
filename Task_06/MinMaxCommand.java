
package Task_06;

import java.util.concurrent.TimeUnit;

import Task_0203.Item2d;
import Task_0203.ViewResult;
import Task_05.Command;

/**
 * Клас {@code MinMaxCommand} реалізує команду для пошуку мінімального та 
 * максимального вісімкового числа серед набору елементів {@code Item2d}.
 *
 * @author Софія Жаботинська
 */
public class MinMaxCommand implements Command {

    /**
     * Індекс елемента з мінімальним додатнім вісімковим числом.
     */
    private int resultMin = -1;

    /**
     * Індекс елемента з максимальним від'ємним вісімковим числом.
     */
    private int resultMax = -1;

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
     * Конструктор для {@code MinMaxCommand}.
     * 
     * @param viewResult об'єкт для доступу до даних
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає індекс елемента з мінімальним додатнім вісімковим числом.
     * 
     * @return індекс елемента з мінімальним додатнім вісімковим числом
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Повертає індекс елемента з максимальним від'ємним вісімковим числом.
     * 
     * @return індекс елемента з максимальним від'ємним вісімковим числом
     */
    public int getResultMax() {
        return resultMax;
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
     * Виконує пошук мінімального та максимального вісімкового числа.
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax виконується...");
        int size = viewResult.getItems().size();
        for (int idx = 0; idx < size; idx++) {
            Item2d item = viewResult.getItems().get(idx);
            if (item.getOctNumber() < 0) {
                if ((resultMax == -1) || (viewResult.getItems().get(resultMax).getOctNumber() < item.getOctNumber())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || (viewResult.getItems().get(resultMin).getOctNumber() > item.getOctNumber())) {
                    resultMin = idx;
                }
            }
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax готовий. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " знайдений: " +

                    String.format("%d",

                            viewResult.getItems().get(resultMin).getOctNumber()));

        } else {

            System.out.print("Min positive не знайдений.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " знайдений: " +

                    String.format("%d", viewResult.getItems().get(resultMax).getOctNumber()));

        } else {
            System.out.println(" Max negative не знайдений.");
        }
        progress = 100;
    }            
}
