package Task_06;

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


