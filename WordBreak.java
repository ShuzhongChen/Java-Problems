class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>();
        dp[0] = true;

        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (set.contains(s.substring(j, i + 1)) && dp[j]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}