class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] rst = new int[3];
        int[] sum = new int[nums.length + 1];
        int[] leftDp = new int[nums.length];
        int[] rightDp = new int[nums.length];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1, max = sum[k] - sum[0]; i + k < sum.length; i++) {
            if (max >= sum[i + k] - sum[i]) {
                leftDp[i] = leftDp[i - 1];
            } else {
                leftDp[i] = i;
                max = sum[i + k] - sum[i];
            }
        }

        rightDp[nums.length - k] = nums.length - k;

        for (int i = nums.length - k - 1, max = sum[i + k + 1] - sum[i + 1]; i >= 0; i--) {
            if (max >= sum[i + k] - sum[i]) {
                rightDp[i] = rightDp[i + 1];
            } else {
                rightDp[i] = i;
                max = sum[i + k] - sum[i];
            }
        }

        int maxSum = 0;

        for (int i = k; i <= nums.length - 2 * k; i++) {
            int l = leftDp[i - k];
            int r = rightDp[i + k];
            if (sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i] > maxSum) {
                rst[0] = l;
                rst[1] = i;
                rst[2] = r;
                maxSum = sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i];
            }
        }

        return rst;
    }
}