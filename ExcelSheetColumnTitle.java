class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }

        String str = "";

        while (n > 0) {
            char c = (char)('A' + (n - 1) % 26);
            str = c + str;

            n = (n - 1) / 26;
        }

        return str;
    }
}