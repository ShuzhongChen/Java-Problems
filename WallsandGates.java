class Solution {
    public void wallsAndGates(int[][] rooms) {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);
                }
            }
        }
    }

    public void helper(int[][] rooms, int r, int c, int d) {
        if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || d > rooms[r][c]) {
            return;
        }

        rooms[r][c] = d;

        helper(rooms, r + 1, c, d + 1);
        helper(rooms, r - 1, c, d + 1);
        helper(rooms, r, c + 1, d + 1);
        helper(rooms, r, c - 1, d + 1);
    }
}