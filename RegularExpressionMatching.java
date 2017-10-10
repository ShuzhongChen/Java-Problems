class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);

                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    char c3 = p.charAt(j - 2);
                    if (c3 == c1 || c3 == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}