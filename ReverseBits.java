public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rst = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                rst += (1 << (32 - i - 1));
            }
        }

        return rst;
    }
}