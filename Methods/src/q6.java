//Function to find average of a set of numbers passed as arguments
class Average {
    static double findAverage(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        System.out.println(findAverage(10, 20, 30, 40));
    }
}
