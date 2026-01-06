interface Payment {
    void pay();
}

class UPI implements Payment {

    public void pay() {
        System.out.println("Payment done using UPI");
    }
}

class Card implements Payment {

    public void pay() {
        System.out.println("Payment done using Card");
    }
}

public class Abstraction_Interface {
    public static void main(String[] args) {

        Payment p = new UPI();
        p.pay();
    }
}
