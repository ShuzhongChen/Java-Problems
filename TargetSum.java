class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum + S) % 2 != 0 || sum < S) {
            return 0;
        }

        S = (sum + S) / 2;

        int[] dp = new int[S + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j - nums[i] >= 0; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[dp.length - 1];
    }
}