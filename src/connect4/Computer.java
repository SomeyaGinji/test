package connect4;

import java.util.Random;

public class Computer {

    Random random = new Random();

    Computer(){

    }

    int select(int array[][],int score){
        int i,j,decidej;
        Assessment assessment = new Assessment();

        int tmparray[][] = new int[6][7]; //盤面の情報をtmparrayに記憶
        for (int I=0;I<=5;I++){
            for (int J=0;J<=6;J++){
                tmparray[I][J] = array[I][J];
            }
        }

        decidej = random.nextInt(7); //0~6の7つの乱数

        //探索アルゴリズムが下に続く
        //盤面評価のクラスかメソッドが入るかも

        int[] ascore = new int[7];
        int[][] bscore = new int[7][7];
        int[][][] cscore = new int[7][7][7];

        for (int j1=0;j1<=6;j1++) {
            int i1 = 5;
            while (i1 >= 0) {
                if (array[i1][j1] == -1) {
                    array[i1][j1] = 1;
                    break;
                }
                i1--;
                if (i1 == -1) {
                    break;
                }
            }

            ascore[j1] = assessment.calcscore(i1, j1, array, score);
            //System.out.print(ascore[j1]+"  ");

            for (int j2=0;j2<=6;j2++){ //2手先（プレイヤーの番）を考える
                int i2=5;
                while (i2>=0){
                    if (array[i2][j2]==-1){ //空の部分について、
                        array[i2][j2]=0; //プレイヤー球が入ると仮定して
                        break;
                    }
                    i2--;
                    if (i2==-1){
                        break;
                    }
                }

                bscore[j1][j2] = assessment.calcscore(i2,j2,array,ascore[j1]);
                //System.out.print(bscore[j1][j2]+" ");

                for (int j3=0;j3<=6;j3++) {
                    int i3 = 5;
                    while (i3 >= 0) {
                        if (array[i3][j3] == -1) {
                            array[i3][j3] = 1;
                            break;
                        }
                        i3--;
                        if (i3 == -1) {
                            break;
                        }
                    }

                    cscore[j1][j2][j3] = assessment.calcscore(i3, j3, array, bscore[j1][j2]);
                    System.out.print(cscore[j1][j2][j3] + " ");
                    try {
                        array[i3][j3]=-1;
                    } catch (ArrayIndexOutOfBoundsException e){ }

                }

                try {
                    array[i2][j2]=-1;
                } catch (ArrayIndexOutOfBoundsException e){ }

            }

            try {
                array[i1][j1]=-1;
            } catch (ArrayIndexOutOfBoundsException e){ }

        }

        //プレイヤー優勢度が一番低くなるものを探索して打つ手を決める
        int minscore = bscore[0][0];
        for (int j1=0;j1<=6;j1++) {
            for (int j2=0;j2<=6;j2++) {
                if (bscore[j1][j2] < minscore) {
                    minscore = bscore[j1][j2];
                    decidej = j1;
                }
            }
        }

            /*try {
                array[i][j]=-1;
            } catch (ArrayIndexOutOfBoundsException e){

            }*/

        for (int I=0;I<=5;I++){
            for (int J=0;J<=6;J++){
                array[I][J] = tmparray[I][J];
            }
        }

        /*for (j=0;j<=6;j++){
            if (ascore[2][j]<minscore){
                minscore = ascore[2][j];
                decidej = j;
            }
        }*/

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

            }
        }

        for(m=0;m<=5;m++) {
            for (n = 0; n <= 6; n++) {
                //横バージョン
                for (i = 0; i <= 5; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 1; //そこにコンピュータ球が入ったとして
                            if (array[i][j] == 1 && array[i][j + 1] == 1 && array[i][j + 2] == 1 && array[i][j + 3] == 1) { //横に4つ並ぶとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m + 1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n] = -1;
                        }

                    }
                }

                //縦バージョン
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 6; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 0; //そこにコンピュータ球が入ったとして
                            if (array[i][j] == 1 && array[i + 1][j] == 1 && array[i + 2][j] == 1 && array[i + 3][j] == 1) { //縦に4つ並ぶとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m + 1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n] = -1;
                        }

                    }
                }

                //斜め（右肩下がり）バージョン
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 1; //そこにコンピュータ球が入ったとして
                            if (array[i][j] == 1 && array[i + 1][j + 1] == 1 && array[i + 2][j + 2] == 1 && array[i + 3][j + 3] == 1) { //斜め（右肩下がり）に4つ並ぶとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m + 1; I--) {
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n] = -1;
                        }

                    }
                }

                //斜め（右肩上がり）バージョン
                for (i = 3; i <= 5; i++) {
                    for (j = 0; j <= 3; j++) {
                        if (array[m][n] == -1) { //空の部分について、
                            array[m][n] = 1; //そこにコンピュータ球が入ったとして
                            if (array[i][j] == 1 && array[i - 1][j + 1] == 1 && array[i - 2][j + 2] == 1 && array[i - 3][j + 3] == 1) { //斜め（右肩上がり）に4つ並ぶとき
                                //array[m][n] = -1;
                                count = 0;
                                for (int I = 5; I >= m + 1; I--) { //調べてる所に球を入れることは可能か調べる
                                    if (array[I][n] != -1) {
                                        count++;
                                    }
                                }
                                if (count == 5 - m) {
                                    decidej = n;
                                }
                            }
                            array[m][n] = -1;
                        }

                    }
                }

            }
        }


        System.out.println("コンピュータは"+(decidej+1)+"列に◯を入れました。");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (decidej==-1){
            decidej=0;
        }

        return decidej;
    }
}
