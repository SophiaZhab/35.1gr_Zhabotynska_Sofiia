package Task_04;
import Task_03.View;
/**
 * Цей клас `Main` є підкласом `Task_03.Main`.
 * Містить реалізацію статичного методу main()
 */
public class Main extends Task_03.Main {
    /** Ініціалізує поле {@linkplain Task_03.Main#view view} */
    public Main(View view){
        super(view);
    }
    /**
     * Цей метод виконує такі дії:
     *  - Створює екземпляр класу `ViewTable` для роботи з табличними даними.
     *  - Ініціалізує таблицю за допомогою `viewInit()`.
     *  - Створює екземпляр класу `Main` з екземпляром класу `ViewableTable`.
     *  - Викликає метод `menu()` цього екземпляра.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args){
        ViewTable viewTable = new ViewTable(40);
        viewTable.viewInit();
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
