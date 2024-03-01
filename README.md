# 35.1gr_Zhabotynska_Sofiia
## Завдання 01.03.24
Простенька консольна програма, що переводить число з десяткової системи числення у двійкову
## Код програми
```java 
package task1;
import java.util.Scanner;
    /**
     * Метод, що запитує у користувача ціле число, а потім перетворює його в двійкове число.
     */
public class Main {
    public static void main(String[] args){
        /**
        * Сканер для читання даних з консолі.
        */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число: ");
        /**
        * Десяткове число, введене користувачем.
        */
        int decimalNum = scanner.nextInt();
        scanner.close();
        String binaryNum = "";
        /**
        * Двійкове представлення десяткового числа.
        */
        while (decimalNum > 0) {
            binaryNum = decimalNum % 2 + binaryNum;
            decimalNum /=2;
        }
        /**
         * Вивід на екран двійкове представлення десяткового числа.
         */
        System.out.println("Двійкове число: " + binaryNum);
    }
}
```
