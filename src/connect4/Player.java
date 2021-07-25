package connect4;

import java.util.Scanner;

public class Player {

    Player(){

    }

    int select(int array[][]){
        int j;
        System.out.println("プレイヤーの球は●です。どの列に入れますか？（1～7から選んで数字のみ入力）\n" +
                "※ゲームを終了するときは0を入力してください。");
        Scanner scanner = new Scanner(System.in);
        j = scanner.nextInt();
        while(true){
            if(j==0){
                break;
            }
            else if (j!=1 && j!=2 && j!=3 && j!=4 && j!=5 && j!=6 && j!=7){
                System.out.println("入力エラーです。どの列に●を入れますか（１～７から選んで数字のみを入力）");
                j = scanner.nextInt();
            }
            else if(array[0][j-1] == 0 || array[0][j-1] == 1 ){ //選んだ列の最上段にすでに球が入っているとき
                System.out.println("これ以上その列に●を入れることはできません。どの列に●を入れますか（１～７から選んで数字のみを入力）");
                j = scanner.nextInt();
            }
            else{
                break;
            }
        }
        return j-1;
    }

}
