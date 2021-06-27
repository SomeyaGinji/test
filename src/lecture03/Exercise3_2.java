package lecture03;

import java.util.Scanner;
import java.util.ArrayList;

public class Exercise3_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String>strings = new ArrayList<>();

        System.out.println("何行分入力しますか？");
        int number=scanner.nextInt();
        for(int i=0;i<number;i++) {
            System.out.println(i + "行目:");
            String input = scanner.next();
            strings.add(input);
        }
        System.out.println("入力した文字列:");
        for (String string : strings) {
            System.out.println("["+strings.indexOf(string)+"]"+string);
        }



    }
}
