package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число в десятковій системі числення: ");
        int decimalValue = scanner.nextInt();
        scanner.close();
    }
    
}
