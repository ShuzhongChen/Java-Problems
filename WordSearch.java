class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(i)) {
            return false;
        }

        board[r][c] = '#';

        boolean rst = search(board, word, r + 1, c, i + 1)
                || search(board, word, r - 1, c, i + 1)
                || search(board, word, r, c + 1, i + 1)
                || search(board, word, r, c - 1, i + 1);

        board[r][c] = word.charAt(i);

        return rst;
    }
}