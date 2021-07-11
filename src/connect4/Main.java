package connect4;

public class Main {
    public static void main(String[] args) {

        Start start = new Start();
        Player player = new Player();

        start.gamestart();
        start.decideturn();
        if (true){
            player.select();
        }
        //while文が続く
    }
}
