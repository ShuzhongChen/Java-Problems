class Solution {

    int[] n;
    Random random;

    public Solution(int[] nums) {
        n = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int rst = 0;

        for (int i = 0; i < n.length; i++) {
            if (n[i] == target) {
                if (random.nextInt(++count) == 0) {
                    rst = i;
                }
            }
        }

        return rst;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */