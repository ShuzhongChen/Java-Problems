class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] rst = new int[n];

        if (logs.size() == 0) {
            return rst;
        }

        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");

            int index = Integer.parseInt(log[0]);
            int time = Integer.parseInt(log[2]);

            if(!stack.isEmpty()) {
                rst[stack.peek()] += time - prevTime;
            }

            if (log[1].equals("start")) {
                stack.push(index);
                prevTime = time;
            } else {
                rst[stack.pop()]++;
                prevTime = time + 1;
            }

        }

        return rst;
    }
}