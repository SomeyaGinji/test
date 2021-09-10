package connect4;

public class Assessment {

    int score;
    int[][] valuearray = new int[6][7];
    int theoryscore;

    Assessment(){
        this.score=0; //盤面評価の点数
        this.valuearray[0][0]=3; //各マスの価値を設定、左上の３×３マス分から
        this.valuearray[0][1]=4;
        this.valuearray[0][2]=5;
        this.valuearray[1][0]=4;
        this.valuearray[1][1]=6;
        this.valuearray[1][2]=8;
        this.valuearray[2][0]=5;
        this.valuearray[2][1]=8;
        this.valuearray[2][2]=11;
        for (int i=0;i<3;i++){ //線対称・点対称の考えで左下・右上・右下の３×３マス分も設定
            for (int j=0;j<3;j++){
                this.valuearray[5-i][j] = valuearray[i][j];
                this.valuearray[i][6-j] = valuearray[i][j];
                this.valuearray[5-i][6-j] = valuearray[i][j];
            }
        }
        for (int i=0;i<6;i++){ //最後に中央列(j=3)の価値を設定、たまたま横の列の価値+２
            this.valuearray[i][3] = valuearray[i][2]+2;
        }

    }

    int calcscore(int i,int j,int array[][],int score){
        theoryscore = 0;
        try {
            if (array[i][j] == array[i-1][j-1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i-2][j-2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
            /*if (array[i][j] == array[i-1][j]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i-2][j]){
                    theoryscore = theoryscore + 3;
                }
            }*/
        try {
            if (array[i][j] == array[i-1][j+1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i-2][j+2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            if (array[i][j] == array[i][j-1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i][j-2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            if (array[i][j] == array[i][j+1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i][j+2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            if (array[i][j] == array[i+1][j-1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i+2][j-2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            if (array[i][j] == array[i+1][j]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i+2][j]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            if (array[i][j] == array[i+1][j+1]){
                theoryscore = theoryscore + 2;
                if (array[i][j] == array[i+2][j+2]){
                    theoryscore = theoryscore + 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }



        try {
            if (array[i][j]==0) {
                score = score + valuearray[i][j] + theoryscore;
            }

            else if (array[i][j]==1){
                score = score - valuearray[i][j] - theoryscore;
            }

        } catch (ArrayIndexOutOfBoundsException e){

        }

        return score;

    }

}
