public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int factor = 1;
        int sum = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (factor << i)) != 0) {
                sum++;
            }
        }

        return sum;
    }
}