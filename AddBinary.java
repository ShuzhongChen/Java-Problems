class Solution {
    public String addBinary(String a, String b) {
        int[] rst = new int[Math.max(a.length(), b.length())];
        int i = rst.length - 1;
        int i1 = a.length() - 1;
        int i2 = b.length() - 1;
        int carry = 0;

        while (i >= 0) {
            int n1 = i1 >= 0 ? Character.getNumericValue(a.charAt(i1)) : 0;
            int n2 = i2 >= 0 ? Character.getNumericValue(b.charAt(i2)) : 0;
            rst[i] = (n1 + n2 + carry) % 2;
            carry = (n1 + n2 + carry) / 2;
            i--;
            i1--;
            i2--;
        }

        String s = "";
        i = 0;

        if (carry > 0) {
            s = "1";
        }

        for (; i < rst.length; i++) {
            s = s + rst[i];
        }

        return s;
    }
}