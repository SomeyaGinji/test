package connect4;

import java.util.Scanner;

public class Player {

    Player(){

    }

    int select(){
        System.out.println("プレイヤーの球は●です。どの列に入れますか？（1～7から選んで数字のみ入力\n" +
                "※ゲームを終了するときは0を入力してください。");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
