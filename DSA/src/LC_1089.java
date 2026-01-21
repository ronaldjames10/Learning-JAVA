class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Count zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        // Start from the end
        int i = n - 1;
        int j = n + zeros - 1;

        while (i < j) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}
