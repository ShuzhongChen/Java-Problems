class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            int tmp = 0;
            set.add(n);

            while (n != 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }

            n = tmp;
        }

        return n == 1;
    }
}