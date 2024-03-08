package Task_06;

import java.util.concurrent.TimeUnit;
import Task_03.Item2d;
import Task_03.ViewResult;
import Task_05.Command;

public class AvgCommand implements Command {
    private int result = 0;

    private int progress = 0;
    private ViewResult viewResult;

    public ViewResult getViewResult() {
        return viewResult;
    }

    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public double getResult() {
        return result;
    }

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
    
      @Override
                public void run() {
                execute();
              }
     
}
