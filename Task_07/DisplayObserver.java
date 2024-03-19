package Task_07;

public class DisplayObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Display: " + message);
    }
}
