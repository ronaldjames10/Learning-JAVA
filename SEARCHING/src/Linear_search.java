class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {15, 22, 9, 31, 7};
        int target = 7;

        int index=-1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1)
            System.out.println("Found at index " + index);
        else
            System.out.println("Not found");
    }
}
