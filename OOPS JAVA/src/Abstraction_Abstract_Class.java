abstract class Vehicle {

    abstract void start();

    void fuel() {
        System.out.println("Vehicle needs fuel");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with kick");
    }
}

public class Abstraction_Abstract_Class {
    public static void main(String[] args) {

        Vehicle v = new Bike();
        v.start();
        v.fuel();
    }
}
