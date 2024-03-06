package Task_04;
import Task_03.View;

public class Main extends Task_03.Main {
    public Main(View view){
        super(view);
    }
    public static void main(String[] args){
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
