package lecture03;

import java.util.Scanner;

public class Exercise3_3 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("1つ目の整数を入力してください:");
        String input1 = scanner.nextLine();
        int number1 = Integer.parseInt(input1);
        System.out.println("2つ目の整数を入力してください:");
        String input2 = scanner.nextLine();
        int number2 = Integer.parseInt(input2);

        int sum = number1 + number2;
        System.out.println(number1+"+"+number2+"="+sum);
    }
}
