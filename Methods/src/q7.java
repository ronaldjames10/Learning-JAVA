//Repeat Question 4 using Recursion
class PatternRecursive1 {
    static void printPattern(int n) {
        if (n == 0)
            return;

        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        printPattern(n - 1);
    }

    public static void main(String[] args) {
        printPattern(4);
    }
}
