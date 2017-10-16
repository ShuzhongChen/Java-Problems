class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int l = 0;
        int r = x;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int midSquare = mid * mid;

            if (midSquare == x) {
                return mid;
            } else if (midSquare > x) {
                r = mid;
            } else {
                if (midSquare / mid != mid) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }

        int rSquare = r * r;

        if (rSquare <= x && rSquare / r == r) {
            return r;
        }

        return l;
    }
}