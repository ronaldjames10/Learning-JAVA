import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0, right = n - 1;
        long result = 0;

        // precompute powers of 2
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return (int) result;
    }
}