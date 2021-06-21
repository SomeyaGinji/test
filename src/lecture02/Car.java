package lecture02;

public class Car {

    int fuel;
    Tire[] tires = new Tire[4];
    Engine engine;

    Car(){
        this.fuel=0;
    }

    Car(Tire[] tires,Engine engine) {

        this.tires = tires;
        this.engine = engine;
        this.fuel = 0;

    }

    void startEngine(){
        engine.start();
    }

    void run(){
        if(fuel>0) {
            fuel = fuel - 1;
            System.out.println("燃料を1消費して走りました。");
        }
        else {
            System.out.println("燃料が足りないため走れませんでした。");
        }
    }

}
