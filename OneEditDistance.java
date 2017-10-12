class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        int len = Math.min(s.length(), t.length());

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i)) || s.substring(i).equals(t.substring(i + 1))
                        || s.substring(i + 1).equals(t.substring(i + 1));
            }
        }

        return s.length() != t.length();
    }
}