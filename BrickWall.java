class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int sum = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                sum += list.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int n : map.keySet()) {
            max = Math.max(map.get(n), max);
        }

        return wall.size() - max;
    }
}