package connect4;

public class Judge {

    Judge(){

    }

    public boolean judge(int array[][]){
        int i,j;
        for(i=0;i<=5;i++){
            for(j=0;j<=3;j++) {
                if((array[i][j]==0&&array[i][j+1]==0&&array[i][j+2]==0&&array[i][j+3]==0)
                ||(array[i][j]==1&&array[i][j+1]==1&&array[i][j+2]==1&&array[i][j+3]==1)){ //横に4つ並んだとき
                    System.out.print("球が横に4つ並びました。");
                    return true;
                }
            }
        }
        for(i=0;i<=2;i++){
            for(j=0;j<=6;j++) {
                if((array[i][j]==0&&array[i+1][j]==0&&array[i+2][j]==0&&array[i+3][j]==0)
                        ||(array[i][j]==1&&array[i+1][j]==1&&array[i+2][j]==1&&array[i+3][j]==1)){ //縦に4つ並んだとき
                    System.out.print("球が縦に4つ並びました。");
                    return true;
                }
            }
        }
        for(i=0;i<=2;i++){
            for(j=0;j<=3;j++) {
                if((array[i][j]==0&&array[i+1][j+1]==0&&array[i+2][j+2]==0&&array[i+3][j+3]==0)
                        ||(array[i][j]==1&&array[i+1][j+1]==1&&array[i+2][j+2]==1&&array[i+3][j+3]==1)){ //斜め（右肩下がり）に4つ並んだとき
                    System.out.print("球が斜めに4つ並びました。");
                    return true;
                }
            }
        }
        for(i=3;i<=5;i++){
            for(j=0;j<=3;j++) {
                if((array[i][j]==0&&array[i-1][j+1]==0&&array[i-2][j+2]==0&&array[i-3][j+3]==0)
                        ||(array[i][j]==1&&array[i-1][j+1]==1&&array[i-2][j+2]==1&&array[i-3][j+3]==1)){ //斜め（右肩上がり）に4つ並んだとき
                    System.out.print("球が斜めに4つ並びました。");
                    return true;
                }
            }
        }

        // まだ決着がつかないとき
        return false;
    }
}
