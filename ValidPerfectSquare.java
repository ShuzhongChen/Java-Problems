class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int sqr = mid * mid;

            if (sqr == num) {
                return true;
            } else if (sqr < num && sqr / mid == mid) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (l * l == num || r * r == num) {
            return true;
        }

        return false;
    }
}