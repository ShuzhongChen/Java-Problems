class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();

        int index1 = 0;
        int index2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }

        int[] rst = new int[list.size()];

        for (int i = 0; i < rst.length; i++) {
            rst[i] = list.get(i);
        }

        return rst;
    }
}