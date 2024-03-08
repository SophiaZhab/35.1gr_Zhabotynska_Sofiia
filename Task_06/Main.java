package Task_06;

import Task_03.ViewableResult;
import Task_03.View;
import Task_05.ChangeConsoleCommand;
import Task_05.GenerateConsoleCommand;
import Task_05.Menu;
import Task_05.ViewConsoleCommand;

public class Main {
    private View view = new ViewableResult().getView();
    
    private Menu menu = new Menu();

    
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
