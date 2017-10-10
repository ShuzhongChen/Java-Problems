class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int n1 = Integer.parseInt(s.substring(i - 1, i));
            int n2 = Integer.parseInt(s.substring(i - 2, i));

            if (n1 >= 1 && n1 <= 9) {
                dp[i] = dp[i - 1];
            }

            if (n2 >= 10 && n2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}