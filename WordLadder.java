class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int count = 1;

        q.add(beginWord);

        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String str = q.poll();

                if (str.equals(endWord)) {
                    return count;
                }

                helper(str, q, set);
            }

            count++;
        }

        return 0;
    }

    public void helper(String str, Queue<String> q, HashSet<String> set) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            char c = chars[i];
            for (int j = 0; j < 26; j++) {
                chars[i] = (char)('a' + j);
                String tmp = String.valueOf(chars);

                if (set.contains(tmp)) {
                    set.remove(tmp);
                    q.add(tmp);
                }
            }
            chars[i] = c;
        }
    }
}