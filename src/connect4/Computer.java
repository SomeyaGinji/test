package connect4;

import java.util.Random;

public class Computer {

    Random random = new Random();
    Assessment assessment;

    Computer(){

    }

    int select(int array[][]){

        //探索アルゴリズムが下に続く
        //盤面評価のクラスかメソッドが入るかも

        //どの手が最善か決める




        int randomj = random.nextInt(7); //0~6の7つの乱数
        System.out.println("コンピュータは"+(randomj+1)+"列に◯を入れました。");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return randomj;
    }
}
