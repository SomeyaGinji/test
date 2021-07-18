package connect4;

import java.util.Scanner;

public class Start {

    Start(){

    }

    public void gamestart(){
        System.out.println("コネクトフォーを始めます。\n＜ルール説明＞\n" +
                "①プレイヤーとコンピュータが交互に球（●や○）を入れます。\n" +
                "②球を入れる列を１～７から1つ選択してください。\n" +
                "③先に自分の球を縦・横・斜めいずれかの方向に４つ並べれば勝利です。\n");
    }

    //盤面の初期化をするメソッドを作る...?

    public boolean decideturn(){
        System.out.println("先攻を決めてください。（プレイヤーが先攻なら1、後攻なら2を入力）");
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        if (flag==1){
            return true;
        } else {
            return false;
        }
    }
}
