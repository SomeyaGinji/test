package connect4;

import java.util.Scanner;

public class Player {

    Player(){

    }



    int select(int array[][]){
        System.out.println("プレイヤーの球は●です。どの列に入れますか？（1～7から選んで数字のみ入力\n" +
                "※ゲームを終了するときは0を入力してください。");
        Scanner scanner = new Scanner(System.in);
        /*int j = scanner.nextInt();
        int i;
        for(i=0;i<6;i++){
            if (array[i][j]==-1){
                break;
            }
        }*/
        return scanner.nextInt()-1;
    }

}
