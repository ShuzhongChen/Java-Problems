class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int index = 0;
        String rst = "";

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            count++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);

            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);

                if (map.get(c1) >= 0) {
                    count--;
                }

                while (count <= 0) {
                    if (rst.length() == 0 || rst.length() > i - index + 1) {
                        rst = s.substring(index, i + 1);
                    }
                    char c2 = s.charAt(index);

                    if (map.containsKey(c2)) {
                        map.put(c2, map.get(c2) + 1);

                        if (map.get(c2) > 0) {
                            count++;
                        }
                    }

                    index++;
                }
            }
        }

        return rst;

    }
}