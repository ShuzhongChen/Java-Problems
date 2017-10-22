class Solution {
    public int titleToNumber(String s) {
        int i = 0;
        int rst = 0;

        while (i < s.length()) {
            int n = s.charAt(i) - 'A';
            rst = rst * 26 + n + 1;
            i++;
        }

        return rst;
    }
}