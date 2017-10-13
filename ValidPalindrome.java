class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);

            if (!Character.isLetterOrDigit(c1)) {
                l++;
            } else if (!Character.isLetterOrDigit(c2)) {
                r--;
            } else {
                c1 = Character.toLowerCase(c1);
                c2 = Character.toLowerCase(c2);

                if (c1 != c2) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
        }

        return true;
    }
}