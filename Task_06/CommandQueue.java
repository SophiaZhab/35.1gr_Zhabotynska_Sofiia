package Task_06;

import java.util.Queue;
import java.util.Vector;
import Task_05.Command;

public interface Queue {
  void put(Command cmd);

  /**
   * Удаляет задачу из очереди;
   * шаблон Worker Thread
   * 
   * @return удаляемая задача
   */
  Command take();
}

public class CommandQueue implements Queue {

  private Vector<Command> tasks;

  private boolean waiting;

  private boolean shutdown;

  public void shutdown() {
    shutdown = true;
  }

  public CommandQueue() {
    tasks = new Vector<Command>();
    waiting = false;
    new Thread(new Worker()).start();
  }

  @Override
  public synchronized void put(Command cmd) {
    tasks.add(cmd);
    if (waiting) {
      notifyAll();
    }
  }

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

  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    Iterator<?> it = tasks.iterator();
    while (it.hasNext()) {
      if (!c.contains(it.next())) {
        it.remove();
        modified = true;
      }
    }
    return modified;
  }

  private class Worker implements Runnable {

    public void run() {
      while (!shutdown) {
        Command r = take();
        r.execute();
      }
    }
  }
}
