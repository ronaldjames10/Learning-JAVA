class Teacher {
    void teach() {
        System.out.println("Teaching...");
    }
}

class Student {
    void study(Teacher t) {
        t.teach();
    }
}
