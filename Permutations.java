class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        permuteHelper(nums, rst, list, set);

        return rst;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> rst, List<Integer> list, HashSet<Integer> set) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
                permuteHelper(nums, rst, list, set);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}