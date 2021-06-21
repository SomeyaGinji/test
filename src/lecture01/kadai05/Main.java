package lecture01.kadai05;

public class Main {
    public static void main(String[] args) {
        int i;
        int[] score={41,85,72,38,80};
        int max=max(score);
        int min=min(score);
        double ave=ave(score);
        for(i=0;i<score.length;i++) {
            System.out.println(i+"番 "+score[i]+"点　");
            if(score[i]>=90)System.out.println("秀");
            else if(score[i]>=80)System.out.println("優");
            else if(score[i]>=70)System.out.println("良");
            else if(score[i]>=60)System.out.println("可");
            else System.out.println("不可");
        }
        System.out.println("最低点:"+min+"点");
        System.out.println("最高点:"+max+"点");
        System.out.println("平均点:"+ave+"点");
    }
    static int min(int[] score) {
        int i,min;
        min = score[0];
        for (i = 1; i < 5; i++) {
            if (score[i] < min) {
                min = score[i];
            }
        }
        return min;
    }
    static int max(int[] score){
        int i,max;
        max = score[0];
        for (i = 1; i < 5; i++) {
            if (score[i] > max) {
                max = score[i];
            }
        }
        return max;
    }
    static double ave(int[] score){
        int i,sum=0;
        double ave;
        for(i=0;i<5;i++){
            sum=sum+score[i];
        }
        return ave=(double)sum/5;
    }
}
