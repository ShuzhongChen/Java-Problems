class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int n1 = -1;
        int n2 = -1;

        for (int i = 0; i < costs[0].length; i++) {
            if (min1 > costs[0][i]) {
                min2 = min1;
                n2 = n1;
                min1 = costs[0][i];
                n1 = i;

            } else if (min2 > costs[0][i]) {
                min2 = costs[0][i];
                n2 = i;
            }
        }

        for (int i = 1; i < costs.length; i++) {
            int prevN1 = -1;
            int prevN2 = -1;
            int tmpmin1 = Integer.MAX_VALUE;
            int tmpmin2 = Integer.MAX_VALUE;

            for (int j = 0; j < costs[0].length; j++) {
                if (j != n1) {
                    costs[i][j] = min1 + costs[i][j];
                } else {
                    costs[i][j] = min2 + costs[i][j];
                }

                if (costs[i][j] < tmpmin1) {
                    tmpmin2 = tmpmin1;
                    prevN2 = prevN1;
                    tmpmin1 = costs[i][j];
                    prevN1 = j;
                } else if (costs[i][j] < tmpmin2) {
                    tmpmin2 = costs[i][j];
                    prevN2 = j;
                }
            }

            n1 = prevN1;
            n2 = prevN2;
            min1 = tmpmin1;
            min2 = tmpmin2;
        }

        return min1;
    }
}