class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int len = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                if (len == 0 || len > i - start + 1) {
                    len = i - start + 1;
                }
                sum -= nums[start++];
            }
        }

        return len;
    }
}