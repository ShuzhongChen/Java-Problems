class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        int rst = -1;

        for (char c : map.keySet()) {
            int n = map.get(c);
            if (n != -1) {
                rst = rst == -1 ? n : Math.min(n, rst);
            }
        }

        return rst;
    }
}