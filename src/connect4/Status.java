package connect4;

public class Status {

    int[][] array = new int[6][7];

    Status(){
        int i,j;
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                this.array[i][j] = -1; //-1は空の状態、0はプレイヤー球●、1はコンピュータ球◯を表す
            }
        }
    }

}
