class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}