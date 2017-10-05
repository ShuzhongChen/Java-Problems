class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[zero];
                nums[zero++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}