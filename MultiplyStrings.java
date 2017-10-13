class Solution {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        String s = "";

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = Character.getNumericValue(num1.charAt(i));
                int n2 = Character.getNumericValue(num2.charAt(j));
                int n = n1 * n2 + digits[i + j + 1];

                digits[i + j + 1] = n % 10;
                digits[i + j] += n / 10;   // don't forget, it's +=, not =
            }
        }

        int index = 0;

        while (index < digits.length && digits[index] == 0) {
            index++;
        }

        for (; index < digits.length; index++) {
            s = s + digits[index];
        }

        return s.length() == 0 ? "0" : s;
    }
}