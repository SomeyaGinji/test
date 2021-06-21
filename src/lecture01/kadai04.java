package lecture01;

public class kadai04 {
    public static void main(String[] args) {
        int[] array=new int[100];
        int sum=0;
        for(int i=0;i<100;i++){
            array[i]=i+1;
            if(array[i]%2==0){
                sum+=array[i];
            }
        }
        System.out.println(sum);
    }
}
