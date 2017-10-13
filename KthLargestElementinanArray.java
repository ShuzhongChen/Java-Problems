class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        k = nums.length - k;

        while (l < r) {
            int mid = quickSelect(nums, l, r);

            if (mid == k) {
                return nums[mid];
            } else if (mid > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];
    }

    public int quickSelect(int[] nums, int l, int r) {
        int pivot = l;
        while (l <= r) {
            while (l <= r && nums[l] <= nums[pivot]) {
                l++;
            }
            while (l <= r && nums[r] > nums[pivot]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }

        int tmp = nums[r];
        nums[r] = nums[pivot];
        nums[pivot] = tmp;

        return r;
    }
}