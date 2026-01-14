import java.util.Scanner;
public class bubble2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //array length
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        // array length input
        int [] arr = new int [n];
        System.out.print(" Enter elements: ");
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Input array: ");
        for (int i = 0; i < n ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // move to next line
        // bubble sort
        for (int i = 0 ; i <n-1; i++){
            for (int j = 0 ; j <n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
