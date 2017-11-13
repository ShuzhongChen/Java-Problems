class Solution {
    public int missingNumber(int[] nums) {
        int factor = 0;

        for (int i = 0; i <= nums.length; i++) {
            factor ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            factor ^= nums[i];
        }

        return factor;
    }
}