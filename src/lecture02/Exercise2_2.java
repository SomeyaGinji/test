package lecture02;

public class Exercise2_2 {
    public static void main(String[] args) {

        Car car = new Car();
        GasStation gasstation = new GasStation();

        car.run();
        gasstation.refuel(car);
        car.run();

    }
}
