class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];

            if (!map.containsKey(c)) {
                map.put(c, count);
                count++;
            } else {
                if (map.get(c) < count - n) {
                    map.put(c, count);
                    count++;
                } else {
                    count = map.get(c) + n + 1;
                    map.put(c, count);
                    count++;
                }
            }
        }

        return count;
    }
}