package Task_06;

import java.util.concurrent.TimeUnit;
import Task_03.View;
import Task_03.ViewResult;
import Task_05.ConsoleCommand;

/**
 * Клас {@code ExecuteConsoleCommand} реалізує консольну команду для виконання
 * команд обробки даних.
 *
 * @author Софія Жаботинська
 */
public class ExecuteConsoleCommand implements ConsoleCommand {
    private View view;

    /**
     * Повертає значення поля {@code view}.
     *
     * @return значення поля {@code view}
     */
    public View getView() {
        return view;
    }

    /**
     * Встановлює значення поля {@code view}.
     *
     * @param view значення для поля {@code view}
     * @return нове значення поля {@code view}
     */
    public View setView(View view) {
        return this.view = view;
    }

    /**
     * Конструктор для {@code ExecuteConsoleCommand}.
     *
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */

    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає символ, що відповідає даній команді.
     *
     * @return символ 'и'
     */
    @Override
    public char getKey() {
        return 'и';
    }

    /**
     * Повертає текстове представлення команди.
     *
     * @return рядок "в'и'конати"
     */
    @Override
    public String toString() {
        return "в'и'конати";
    }

    /**
     * Виконує обробку даних.
     *
     * Створює черги команд {@link CommandQueue} для паралельного виконання
     * команд {@link MaxCommand}, {@link AvgCommand} та {@link MinMaxCommand}.
     * Відправляє команди до черг та очікує їх завершення.
     */
    @Override
    public void execute() {

        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        MaxCommand maxCommand = new MaxCommand((ViewResult) view);
        AvgCommand avgCommand = new AvgCommand((ViewResult) view);
        MinMaxCommand minMaxCommand = new MinMaxCommand((ViewResult) view);
        System.out.println("Виконую всі потоки...");

        queue1.put(minMaxCommand);
        queue2.put(maxCommand);
        queue2.put(avgCommand);
        
        try {
            while (avgCommand.running() ||
                    maxCommand.running() ||
                    minMaxCommand.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }

            queue1.shutdown();
            queue2.shutdown();

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("Усе готово.");
    }
}
