/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;

        while (l + 1 < h) {
            int mid = l + (h - l) / 2;

            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid;
            }
        }

        if (isBadVersion(l)) {
            return l;
        }

        return h;
    }
}