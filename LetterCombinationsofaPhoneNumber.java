class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if (digits.length() == 0) {
            return list;
        }

        String[] letters = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        int index = 0;

        q.add("");

        while (index < digits.length()) {
            int size = q.size();
            int n = Character.getNumericValue(digits.charAt(index));

            for (int i = 0; i < size; i++) {
                String s = q.poll();

                for (int j = 0; j < letters[n].length(); j++) {
                    q.add(s + letters[n].charAt(j));
                }
            }
            index++;
        }

        while (!q.isEmpty()) {
            list.add(q.poll());
        }

        return list;
    }
}