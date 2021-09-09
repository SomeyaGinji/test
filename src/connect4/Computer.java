package connect4;

import java.util.Random;

public class Computer {

    Random random = new Random();
    int[][] ascore = new int[10][7]; //10はdepth

    Computer(){

    }

    int select(int array[][],int score){
        int i,j,decidej;
        Assessment assessment = new Assessment();


        decidej = random.nextInt(7); //0~6の7つの乱数

        //探索アルゴリズムが下に続く
        //盤面評価のクラスかメソッドが入るかも
        for (j=0;j<=6;j++){
            i=5;
            while (i>=0){
                if (array[i][j]==-1){
                    array[i][j]=1;
                    break;
                }
                i--;
                if (i==-1){

                    break;
                }
            }

            ascore[1][j] = assessment.calcscore(i,j,array,score);
            System.out.println(ascore[1][j]);

            array[i][j]=-1;
        }

        int minscore = ascore[1][0];
        for (j=0;j<=6;j++){
            if (ascore[1][j]<minscore){
                minscore = ascore[1][j];
                decidej = j;
            }
        }

        //どの手が最善か決める
        /*int max = assessment.valuearray[0][0];
        for (i=0;i<6;i++){
            for (j=0;j<7;j++){
                if(max < assessment.valuearray[i][j]){

                }
            }
        }*/



        // プレイヤーがリーチなら阻止する手を打つ
        int m,n,count;
        for(m=0;m<=5;m++) {
            for (n = 0; n <= 6; n++) {
                //横バージョン
                for (i = 0; i <= 5; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 0; //そこにプレイヤー球が入ったとして
                            if (array[i][j] == 0 && array[i][j + 1] == 0 && array[i][j + 2] == 0 && array[i][j + 3] == 0) { //横に4つ並んでしまうとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m+1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n]=-1;
                        }

                    }
                }

                //縦バージョン
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 6; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 0; //そこにプレイヤー球が入ったとして
                            if (array[i][j] == 0 && array[i+1][j] == 0 && array[i+2][j] == 0 && array[i+3][j] == 0) { //縦に4つ並んでしまうとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m+1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n]=-1;
                        }

                    }
                }

                //斜め（右肩下がり）バージョン
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 0; //そこにプレイヤー球が入ったとして
                            if (array[i][j] == 0 && array[i+1][j + 1] == 0 && array[i+2][j + 2] == 0 && array[i+3][j + 3] == 0) { //斜め（右肩下がり）に4つ並んでしまうとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m+1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n]=-1;
                        }

                    }
                }

                //斜め（右肩上がり）バージョン
                for (i = 3; i <= 5; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 0; //そこにプレイヤー球が入ったとして
                            if (array[i][j] == 0 && array[i-1][j + 1] == 0 && array[i-2][j + 2] == 0 && array[i-3][j + 3] == 0) { //斜め（右肩上がり）に4つ並んでしまうとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m+1; I--) { //調べてる所に球を入れることは可能か調べる
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n]=-1;
                        }

                    }
                }

                //自分(コンピュータ)がリーチなら勝負を決める
                if (array[m][n]==-1) { //空の部分について
                    array[m][n] = 1; //そこにコンピュータ球が入ったとして、

                    for (i = 0; i <= 5; i++) { //横
                        for (j = 0; j <= 3; j++) {
                            if (array[i][j] == 1 && array[i][j + 1] == 1 && array[i][j + 2] == 1 && array[i][j + 3] == 1) { //横に4つ並んだとき
                                decidej = n;
                            }
                        }
                    }
                    for (i = 0; i <= 2; i++) { //縦
                        for (j = 0; j <= 6; j++) {
                            if (array[i][j] == 1 && array[i + 1][j] == 1 && array[i + 2][j] == 1 && array[i + 3][j] == 1) { //縦に4つ並んだとき
                                decidej = n;
                            }
                        }
                    }
                    for (i = 0; i <= 2; i++) { //斜め右肩下がり
                        for (j = 0; j <= 3; j++) {
                            if (array[i][j] == 1 && array[i + 1][j + 1] == 1 && array[i + 2][j + 2] == 1 && array[i + 3][j + 3] == 1) { //斜め（右肩下がり）に4つ並んだとき
                                decidej = n;
                            }
                        }
                    }
                    for (i = 3; i <= 5; i++) { //右肩上がり
                        for (j = 0; j <= 3; j++) {
                            if (array[i][j] == 1 && array[i - 1][j + 1] == 1 && array[i - 2][j + 2] == 1 && array[i - 3][j + 3] == 1) { //斜め（右肩上がり）に4つ並んだとき
                                decidej = n;
                            }
                        }
                    }
                    array[m][n]=-1; //空の状態に戻す
                }

            }
        }


        System.out.println("コンピュータは"+(decidej+1)+"列に◯を入れました。");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return decidej;
    }
}
