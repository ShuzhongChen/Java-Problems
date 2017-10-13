class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] buckets = new int[10];

        for (int i = 0; i < chars.length; i++) {
            buckets[chars[i] - '0'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                if (buckets[j] > i) {
                    char tmp = chars[i];
                    chars[i] = chars[buckets[j]];
                    chars[buckets[j]] = tmp;

                    return Integer.parseInt(String.valueOf(chars));
                }
            }
        }

        return num;
    }
}