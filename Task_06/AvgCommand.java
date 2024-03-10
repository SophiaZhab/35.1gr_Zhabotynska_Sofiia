package Task_06;

import java.util.concurrent.TimeUnit;
import Task_03.Item2d;
import Task_03.ViewResult;
import Task_05.Command;
/**
 * Клас реалізує команду для обчислення середнього
 * значення вісімкових чисел із набору елементів {@code Item2d}.
 *
 * @author Софія Жаботинська
 */
public class AvgCommand implements Command {
    /**
     * Результат обчислення середнього значення.
     */
    private int result = 0;

    private int progress = 0;
    /**
     * Об'єкт для відображення результату обчислень.
     */
    private ViewResult viewResult;
    /**
     * Повертає поле {@linkplain AvgCommand#viewResult}
     *
     * @return значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /**
     * Встановлює поле {@linkplain AvgCommand#viewResult}
     *
     * @param viewResult значення для {@linkplain AvgCommand#viewResult}
     * @return нове значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
     /**
     * Ініціалізує поле {@linkplain AvgCommand#viewResult}
     *
     * @param viewResult об'єкт класу {@linkplain ViewResult}
     */
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /**
     * Повертає результат
     *
     * @return поле {@linkplain AvgCommand#result}
     */
    public double getResult() {
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

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Середнє виконання...");
        result = 0;
        int idx = 1, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            result += item.getOctNumber();
            progress = idx * 100 / size;

            if (idx++ % (size / 2) == 0) {
                System.out.println("Середнє " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        result /= size;
        System.out.println("Обчислення середнього завершено. Результат = " + String.format("%d", result));
        progress = 100;
    }
     
}
