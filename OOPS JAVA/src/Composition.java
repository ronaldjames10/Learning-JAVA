class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;

    Car() {
        engine = new Engine(); // Strong ownership
    }

    void startCar() {
        engine.start();
    }
}
