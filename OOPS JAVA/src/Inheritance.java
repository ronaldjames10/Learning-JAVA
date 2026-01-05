class Employee {

    int salary = 30000;

    void work() {
        System.out.println("Employee is working");
    }
}

// Child class
class Manager extends Employee {

    void manage() {
        System.out.println("Manager is managing the team..ok");
    }
}
public class Inheritance {
    public static void main(String[] args) {

        Manager m = new Manager();

        // Access parent class members
        System.out.println("Salary: " + m.salary);
        m.work();

        // Access child class method
        m.manage();
    }
}