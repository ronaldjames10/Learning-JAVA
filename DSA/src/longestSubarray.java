public class Main {

    public static int longestSubarray(int[] arr, int k) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= k) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int k = 7;
        System.out.println(longestSubarray(arr, k));
    }
}
