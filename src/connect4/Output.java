package connect4;

public class Output {

    Output(){

    }

    void output(int array[][]){
        int i,j;
        for(j=0;j<7;j++) {
            System.out.println(" " + (j + 1));
        }
        System.out.println(" \n");
        for(i=0;i<6;i++){
            for(j=0;j<7;j++){
                if (array[i][j]==0){
                    System.out.println("|●");
                }
                else if(array[i][j]==1){
                    System.out.println("|◯");
                }
                else{
                    System.out.println("| ");
                }
            }
            System.out.println("|\n");
        }
        for(j=0;j<7;j++){
            System.out.println("__");
        }
        System.out.println("_\n");
    }
}
