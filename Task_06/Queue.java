package Task_06;

import Task_05.Command;


public interface Queue {
  void put(Command cmd);

  /**
    * Видаляє завдання з черги;
    * шаблон Worker Thread
    *
    * @return завдання, що видаляється
    */
  Command take();
}


