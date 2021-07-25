package connect4;

public class Output {

    Output(){

    }

    void output(int array[][],int score){
        int i,j;
        for(j=0;j<7;j++) {
            System.out.print(" " + (j + 1));
        }
        System.out.print(" \n");
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                if (array[i][j]==0){
                    System.out.print("|●");
                }
                else if(array[i][j]==1){
                    System.out.print("|◯");
                }
                else{
                    System.out.print("| ");
                }
            }
            System.out.print("|\n");
        }
        for(j=0;j<7;j++){
            System.out.print("--");
        }
        System.out.print("-\n");

        System.out.println("プレイヤーの優勢度: "+score+"\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
