class Solution {
    public String removeInvalidParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count >= 0) {
                sb.append(s.charAt(i));
            } else {
                count = 0;
            }
        }

        count = 0;
        s = sb.toString();
        sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i++) {
            if (s.charAt(i) == ')') {
                count++;
            } else if (s.charAt(i) == '(') {
                count--;
            }

            if (count >= 0) {
                sb.insert(0, s.charAt(i));
            } else {
                count = 0;
            }
        }

        return sb.toString();
    }
}