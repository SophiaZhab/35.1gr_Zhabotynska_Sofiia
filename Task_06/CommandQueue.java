package Task_06;

import java.util.Vector;
import Task_05.Command;

/**
 * Клас {@code CommandQueue} реалізує чергу для зберігання та виконання команд.
 * 
 * @author Софія Жаботинська
 */
public class CommandQueue implements Queue {

  /**
   * Список команд, що очікують на виконання.
   */
  private Vector<Command> tasks;
  /**
   * Прапорець, що вказує, чи потік знаходиться в режимі очікування.
   */
  private boolean waiting;
  /**
   * Прапорець завершення роботи черги.
   */
  private boolean shutdown;

  /**
   * Встановлює прапорець завершення
   */
  public void shutdown() {
    shutdown = true;
  }

  /**
   * Конструктор для {@code CommandQueue}.
   * 
   * Ініціалізує поля {@code tasks}, {@code waiting}, {@code shutdown}
   * і створює новий потік для виконання команд.
   */
  public CommandQueue() {
    tasks = new Vector<Command>();
    waiting = false;
    new Thread(new Worker()).start();
  }

  /**
   * Додає команду до черги.
   * 
   * @param r команда для додавання до черги
   */
  @Override
  public void put(Command r) {
    tasks.add(r);
    if (waiting) {
      synchronized (this) {
        notifyAll();
      }
    }
  }

  /**
   * Бере команду з черги.
   * 
   * @return перша команда в черзі
   */
  @Override
  public Command take() {
    if (tasks.isEmpty()) {
      synchronized (this) {

        waiting = true;
        try {
          wait();
        } catch (InterruptedException ie) {
          waiting = false;
        }
      }
    }
    return (Command) tasks.remove(0);
  }

  /**
   * Обслуговує чергу задач; Pattern Worker Thread
   *
   * @see Runnable
   */
  private class Worker implements Runnable {

    /**
     * Вилучає з черги готові до виконання задачі
     */
    @Override
    public void run() {
      while (!shutdown) {
        Command r = take();
        r.execute();
      }
    }
  }
}
