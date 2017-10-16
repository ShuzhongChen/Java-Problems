class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> preMap = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] rst = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, 0);
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            preMap.put(prerequisites[i][0], preMap.get(prerequisites[i][0]) + 1);
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (preMap.get(i) == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();

            if (preMap.get(course) == 0) {
                rst[index++] = course;
            }

            for (int i = 0; i < map.get(course).size(); i++) {
                int nextCourse = map.get(course).get(i);

                preMap.put(nextCourse, preMap.get(nextCourse) - 1);

                if (preMap.get(nextCourse) == 0) {
                    q.add(nextCourse);
                }
            }
        }

        return index == numCourses ? rst : new int[0];
    }
}