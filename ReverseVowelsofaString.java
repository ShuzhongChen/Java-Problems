class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            while (l < r && !set.contains(chars[l])) {
                l++;
            }
            while (l < r && !set.contains(chars[r])) {
                r--;
            }

            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }

        return String.valueOf(chars);
    }
}