class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dpLength = new int[nums.length];
        int[] dpCount = new int[nums.length];
        int max = 0;
        int rst = 0;

        for (int i = 0; i < nums.length; i++) {
            dpLength[i] = 1;
            dpCount[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dpLength[j] + 1 > dpLength[i]) {
                        dpLength[i] = dpLength[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dpLength[j] + 1 == dpLength[i]) {
                        dpCount[i] += dpCount[j];
                    }
                }
            }

            max = Math.max(dpLength[i], max);
        }

        for (int i = 0; i < dpLength.length; i++) {
            if (dpLength[i] == max) {
                rst += dpCount[i];
            }
        }

        return rst;
    }
}