package 카카오2019;

public class 블록게임 {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;

                if (isA(i, j, board[i][j], n, board) && drop(i + 1, j + 1, board[i][j], board) && drop(i + 1, j + 2, board[i][j], board)) {
                    remove(i, j, i + 1, j, i + 1, j + 1, i + 1, j + 2, board);
                    j = -1;
                    answer++;
                } else if (isB(i, j, board[i][j], n, board) && drop(i + 2, j - 1, board[i][j], board)) {
                    remove(i, j, i + 1, j, i + 2, j, i + 2, j - 1, board);
                    j = -1;
                    answer++;
                } else if (isC(i, j, board[i][j], n, board) && drop(i + 2, j + 1, board[i][j], board)) {
                    remove(i, j, i + 1, j, i + 2, j, i + 2, j + 1, board);
                    j = -1;
                    answer++;
                } else if (isD(i, j, board[i][j], n, board) && drop(i + 1, j - 1, board[i][j], board) && drop(i + 1, j - 2, board[i][j], board)) {
                    remove(i, j, i + 1, j, i + 1, j - 1, i + 1, j - 2, board);
                    j = -1;
                    answer++;
                } else if (isE(i, j, board[i][j], n, board) && drop(i + 1, j - 1, board[i][j], board) && drop(i + 1, j + 1, board[i][j], board)) {
                    remove(i, j, i + 1, j, i + 1, j - 1, i + 1, j + 1, board);
                    j = -1;
                    answer++;
                }
            }
        }

        return answer;
    }

    static boolean isA(int x, int y, int num, int n, int[][] board) {
        if (x + 1 > n - 1 || y + 2 > n - 1) return false;
        return board[x + 1][y] == num && board[x + 1][y + 1] == num && board[x + 1][y + 2] == num;
    }

    static boolean isB(int x, int y, int num, int n, int[][] board) {
        if (x + 2 > n - 1 || y - 1 < 0) return false;
        return board[x + 1][y] == num && board[x + 2][y] == num && board[x + 2][y - 1] == num;
    }

    static boolean isC(int x, int y, int num, int n, int[][] board) {
        if (x + 2 > n - 1 || y + 1 > n - 1) return false;
        return board[x + 1][y] == num && board[x + 2][y] == num && board[x + 2][y + 1] == num;
    }

    static boolean isD(int x, int y, int num, int n, int[][] board) {
        if (x + 1 > n - 1 || y - 2 < 0) return false;
        return board[x + 1][y] == num && board[x + 1][y - 1] == num && board[x + 1][y - 2] == num;
    }

    static boolean isE(int x, int y, int num, int n, int[][] board) {
        if (x + 1 > n - 1 || y - 1 < 0 || y + 1 > n - 1) return false;
        return board[x + 1][y] == num && board[x + 1][y - 1] == num && board[x + 1][y + 1] == num;
    }

    static boolean drop(int x, int y, int num, int[][] board) {
        for (int i = 0; i < x; i++)
            if (board[i][y] != 0) return false;
        return true;
    }

    static void remove(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int[][] board) {
        board[x1][y1] = board[x2][y2] = board[x3][y3] = board[x4][y4] = 0;
    }

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 3, 0, 4, 0, 0, 0}, {0, 0, 0, 2, 3, 0, 0, 0, 5, 5}, {1, 2, 2, 2, 3, 3, 0, 0, 0, 5}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}});
    }
}
