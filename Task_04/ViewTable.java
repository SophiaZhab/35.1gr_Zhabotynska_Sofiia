package Task_04;

import java.util.Formatter;
import Task_03.Item2d;
import Task_03.ViewResult;

public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 51;
    private int width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    public double setWidth(int width) {
        return this.width = width;
    }

    public double getWidth() {
        return width;
    }

    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    public void outLineLn() {
        outLine();
        System.out.println();
    }

    public void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%s%s%s%s%s%s", "| ", "десяткова сис.", " | ", "вісімкова сис.", " | ", "шістнадцяткова", " |");
        System.out.println(fmt);}

    public void outBody() {
        Formatter fmt = new Formatter();
        for(Item2d item : getItems()) {
            fmt.format("%14s %14s %14s\n", item.getDecimalValue(), item.getOctNumber(), item.getHexNumber());}
        System.out.println(fmt);
    
    }

    public final void initWidth(int width) {
        this.width = width;
        viewInit();
    }

    public final void init(int width, int stepdecimalValue) {
        this.width = width;
        init(stepdecimalValue);
    }

    @Override
    public void init(int stepdecimalValue) {
        System.out.print("Ініціалізація... ");
        super.init(stepdecimalValue);
        System.out.println("готово. ");
    }

    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    @Override
    public void viewBody() {
        outBody();
    }

    @Override
    public void viewFooter() {
        outLineLn();
        }
}
