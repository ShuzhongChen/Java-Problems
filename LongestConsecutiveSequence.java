class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!map.containsKey(n)) {

                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int tmpSum = left + right + 1;
                map.put(n - left, tmpSum);
                map.put(n + right, tmpSum);
                map.put(n, tmpSum);

                sum = Math.max(sum, tmpSum);
            }

        }

        return sum;

    }
}