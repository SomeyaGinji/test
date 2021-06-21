package lecture01;

public class Main {
    public static void main(String[] args) {
        //コメントアウト
        System.out.println("We are Project Member.");
        int sum=5+3;
        int sub=5-3;
        int mul=5*3;
        int div=5/3;
        int mod=5%3;
        double temp=18.7;
        System.out.println("The temperature is "+temp+" degrees");
        int[] array = new int[10];
        array[4]=3;
        for(int i=0;i<10;i++) {
        }
        int count=0;
        while(count<100){
            count++;
        }
        String series="XS";
        switch(series) {
            case "X":
                System.out.println("Face IDに対応");
                break;
            case "11":
                System.out.println("Dolby Atmosに対応");
                break;
            case "11 pro":
                System.out.println("タピオカメラ");
                break;
            case "SE":
                System.out.println("8の上位互換");
                break;
            default:
                System.out.println("古き良き時代");
                break;
        }
    }
    static void print(String str){
        System.out.println(str);
    }
}
