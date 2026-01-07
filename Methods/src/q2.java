/*
      Function to print the pattern:
        *
        * *
        * * *
        * * * *
   */
class Pattern1 {
    static void printPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(4);
    }
}
