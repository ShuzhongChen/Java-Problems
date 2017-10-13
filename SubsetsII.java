class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(nums, rst, list, 0);

        return rst;
    }

    public void subsetHelper(int[] nums, List<List<Integer>> rst, List<Integer> list, int i) {
        rst.add(new ArrayList<>(list));

        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                list.add(nums[j]);
                subsetHelper(nums, rst, list, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}