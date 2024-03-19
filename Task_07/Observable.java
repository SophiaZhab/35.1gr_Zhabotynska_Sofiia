package Task_07;

import java.util.ArrayList;
import java.util.List;

// Observable (Subject)
class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Observer
interface Observer {
    void update(String message);

    class LoggerObserver implements Observer {
        @Override
        public void update(String message) {
            System.out.println("Logger: " + message);
        }
    }
    
    // Другий Observer
    class DisplayObserver implements Observer {
        @Override
        public void update(String message) {
            System.out.println("Display: " + message);
        }
    }
}
