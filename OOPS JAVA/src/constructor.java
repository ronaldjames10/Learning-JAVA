class Student {

    String name;
    int age;

    // Parameterized constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class constructor {
    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 20);
        Student s2 = new Student("Anita", 22);

        s1.displayInfo();
        s2.displayInfo();
    }

}
