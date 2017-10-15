class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long AbsN = Math.abs((long)n);
        double rst = 1;

        while (AbsN != 0) {
            rst = (AbsN & 1) == 0 ? rst : rst * x;
            AbsN >>= 1;
            x *= x;
        }

        return n < 0 ? 1 / rst : rst;
    }
}