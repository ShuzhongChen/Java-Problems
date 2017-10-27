class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        int count = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                count++;
            }

            if (count <= k) {
                max = Math.max(i - index + 1, max);
            } else {
                while (count > k) {
                    char tmpChar = s.charAt(index++);
                    map.put(tmpChar, map.get(tmpChar) - 1);

                    if (map.get(tmpChar) == 0) {
                        map.remove(tmpChar);
                        count--;
                    }
                }
            }
        }

        return max;
    }
}