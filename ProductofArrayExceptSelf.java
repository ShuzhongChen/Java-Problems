class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];

        for (int i = 0, tmp = 1; i < nums.length; i++) {
            rst[i] = tmp;
            tmp *= nums[i];
        }

        for (int i = rst.length - 1, tmp = 1; i >= 0; i--) {
            rst[i] *= tmp;
            tmp *= nums[i];
        }

        return rst;
    }
}