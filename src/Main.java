package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число: ");
        int decimalNum = scanner.nextInt();
        scanner.close();
        String binaryNum = "";

        while (decimalNum > 0) {
            binaryNum = decimalNum % 2 + binaryNum;
            decimalNum /=2;
        }
        System.out.println("Двійкове число: " + binaryNum);
    }
    
}
