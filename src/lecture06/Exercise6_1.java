package lecture06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise6_1 {
    public static void main(String[] args) {
        System.out.println("小数値を入力してください:\n");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("入力した値: "+scanner.nextDouble()+"\n");
        } catch (InputMismatchException e){
            System.out.println("エラー\n");
        }
    }
}
