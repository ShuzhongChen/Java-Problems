class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq
                = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });

        pq.addAll(map.entrySet());

        int rst = 0;

        while (!pq.isEmpty()) {
            int k = 0;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            while (k++ <= n && !pq.isEmpty()) {
                Map.Entry<Character, Integer> e = pq.poll();
                e.setValue(e.getValue() - 1);

                if (e.getValue() > 0) {
                    list.add(e);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                pq.add(list.get(i));
            }

            if (!pq.isEmpty()) {
                rst += n + 1;
            } else {
                rst += k - 1;
            }
        }

        return rst;
    }
}