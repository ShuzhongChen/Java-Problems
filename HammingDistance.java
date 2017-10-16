class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int factor = 1;

        for (int i = 0; i < 32; i++) {
            if ((x & (factor << i)) != (y & (factor << i))) {
                count++;
            }
        }

        return count;
    }
}