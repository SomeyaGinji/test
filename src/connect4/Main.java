package connect4;

public class Main {
    public static void main(String[] args) {

        Start start = new Start();
        Player player = new Player();
        Computer computer = new Computer();
        Output output = new Output();
        Judge judge = new Judge();

        int i,j;
        int turn = 0;
        int[][] array = new int[6][7];

        start.gamestart();
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                array[i][j] = -1; //-1は空の状態、0はを表す
            }
        }
        if (start.decideturn()){ //プレイヤー先攻のとき
            //プレイヤーの番
            j = player.select(array);
            array[0][j] = 0;
            //盤面評価のクラスがここに入る
            output.output(array);
        }

        while(true) { //4つ並ぶ、またはいっぱいになるまで繰り返し
            //コンピュータの番
            j = computer.select();
            for(i=0;i<6;i++){
                if (array[i][j]==-1){ //空のとき
                    break;
                }
            }
            array[i][j] = 1; //そこに◯を入れる
            //盤面評価のクラスがここに入る
            output.output(array);
            if (judge.judge()) { //コンピュータ勝利時
                System.out.println("コンピュータの勝利です。");
                break;
            }
            turn++;
            if (turn==42){ //42ターン終了時
                System.out.println("これ以上球が入りません。引き分けです。");
            }
            //プレイヤーの番
            j = player.select(array);
            for(i=0;i<6;i++){
                if (array[i][j]==-1){ //空のとき
                    break;
                }
            }
            array[i][j] = 0; //そこに●を入れる
            //盤面評価のクラスがここに入る
            output.output(array);
            if (judge.judge()) { //プレイヤー勝利時
                System.out.println("プレイヤーの勝利です。");
                break;
            }
            turn++;
            if (turn==42){ //42ターン終了時
                System.out.println("これ以上球が入りません。引き分けです。");
            }
        }

    }
}
