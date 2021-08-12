package connect4;

public class Main {
    public static void main(String[] args) {

        Start start = new Start();
        Player player = new Player();
        Computer computer = new Computer();
        Output output = new Output();
        Judge judge = new Judge();
        Assessment assessment = new Assessment();
        Status status = new Status();

        int i,j;
        int turn = 0;
        int[][] array = new int[6][7];
        int score = 0;

        start.gamestart();
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                array[i][j] = -1; //-1は空の状態、0はプレイヤー球●、1はコンピュータ球◯を表す
            }
        }

        if (start.decideturn()){ //プレイヤー先攻のとき
            //プレイヤーの番
            output.output(array,score);
            j = player.select(array);
            if (j == -1){return; }
            array[5][j] = 0;
            //盤面評価のメソッド
            score = assessment.calcscore(5,j,array,score);
            output.output(array,score);
        }

        while(true) { //4つ並ぶ、またはいっぱいになるまで繰り返し
            //コンピュータの番
            j = computer.select(array);
            for(i=5;i>=0;i--){
                if (array[i][j]==-1){ //空のとき
                    break;
                }
            }
            array[i][j] = 1; //そこに◯を入れる
            //盤面評価のメソッド
            score = assessment.calcscore(i,j,array,score);
            output.output(array,score);
            if (judge.judge(array)) { //コンピュータ勝利時
                System.out.println("コンピュータの勝利です。");
                break;
            }
            turn++;
            if (turn==42){ //42ターン終了時
                System.out.println("これ以上球が入りません。引き分けです。");
            }
            //プレイヤーの番
            j = player.select(array);
            if(j == -1){break;}
            for(i=5;i>-1;i--){
                if (array[i][j]==-1){ //空のとき
                    break;
                }
            }
            array[i][j] = 0; //そこに●を入れる
            //盤面評価のメソッド
            score = assessment.calcscore(i,j,array,score);
            output.output(array,score);
            if (judge.judge(array)) { //プレイヤー勝利時
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
