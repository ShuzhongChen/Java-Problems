class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        helper(nums, rst, list, visited);

        return rst;
    }

    public void helper(int[] nums, List<List<Integer>> rst, List<Integer> list, boolean[] visited) {
        if (nums.length == list.size()) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;

            helper(nums, rst, list, visited);

            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}