class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            if (m1[s1.charAt(i)] != m2[s2.charAt(i)]) {
                return false;
            }

            m1[s1.charAt(i)] = i + 1;
            m2[s2.charAt(i)] = i + 1;
        }

        return true;
    }
}

// use map
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1) && c2 != map1.get(c1)) {
                return false;
            }

            if (map2.containsKey(c2) && c1 != map2.get(c2)) {
                return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }

        return true;
    }
}