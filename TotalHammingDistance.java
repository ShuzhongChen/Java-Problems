class Solution {
    public int totalHammingDistance(int[] nums) {
        int rst = 0;
        int factor = 1;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (factor << i)) != 0) {
                    count++;
                }
            }
            rst += count * (nums.length - count);
        }

        return rst;
    }
}