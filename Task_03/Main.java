package Task_03;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Task_04.ViewTable;

/**
 * Клас для демонстрації серіалізації та десеріалізації.
 */
public class Main {

    public View view;

    public Main(View view) {
        this.view = view;
    }

    /**
     * Об'єкт класу Calculate для виконання розрахунків.
     */

    /**
     * Метод для відображення текстового меню та виклику методів об'єкта Calculate.
     */
    protected void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Введіть букву:");
                System.out.print("'н'азад, 'п'оказати, 'г'енерувати, 'з'берегти, 'в'ідновити: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Помилка: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'н':
                    System.out.println("Виходжу.");
                    break;
                case 'п':
                    System.out.println("Перегляд поточного запису.");
                    view.viewShow();
                    break;
                case 'г':
                    System.out.println("Генерую.");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 'з':
                    System.out.println("Зберігаю поточний.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Помилка серіалізації: " + e);
                    }
                    view.viewShow();
                    break;
                case 'в':
                    System.out.println("Відновлюю останній.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Помилка серіалізації: " + e);
                    }
                    view.viewShow();
                    break;
                default:
                    System.out.print("Невірна команда. ");
            }
        } while (s.charAt(0) != 'н');
    }

    /**
     * Метод для виклику головного меню програми.
     *
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
        }

}