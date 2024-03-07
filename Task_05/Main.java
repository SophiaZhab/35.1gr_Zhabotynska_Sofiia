package Task_05;

/**
 * Обчислення та відображення
 * результатів; містить реалізацію
 * Статичного методу main()
 * 
 * @see Main#main
 */
public class Main {
    /**
     * Виконується під час запуску програми
     * Викликає метод {@linkplain Application#run()}
     * 
     * @param args параметри запуску програми
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}
