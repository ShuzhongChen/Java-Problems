class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        boolean leftside = false;

        if (nums[0] <= target) {
            leftside = true;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (leftside) {
                    r = mid;
                } else {
                    if (nums[mid] < nums[0]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
            } else {
                if (leftside) {
                    if (nums[mid] < nums[0]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                } else {
                    l = mid;
                }
            }
        }

        if (nums[l] == target) {
            return l;
        } else if (nums[r] == target) {
            return r;
        }

        return -1;
    }
}