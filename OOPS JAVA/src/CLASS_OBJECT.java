//// Define a class
//class Student {
//
//    // Fields (data)
//    String name;
//    int age;
//
//    // Method (behavior)
//    void displayInfo() {
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//    }
//}
//
//// Main class
//public class CLASS_OBJECT {
//    public static void main(String[] args) {
//
//        // Creating an object of Student class
//        Student s1 = new Student();
//
//        // Assigning values
//        s1.name = "Rahul";
//        s1.age = 20;
//
//        // Calling method
//        s1.displayInfo();
//    }
//}


class football {
    String club;
    String name ;
    int age ;
    int score;

    void dispaly(){
        System.out.println("Club: " + club);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);

    }

}

public class CLASS_OBJECT  {
    public static void main(String[] args) {
        football f1 = new football();
        f1.club = " Barca";
        f1.name ="Messi";
        f1.age = 38;
        f1.score = 664;
        f1.dispaly();
    }

}
