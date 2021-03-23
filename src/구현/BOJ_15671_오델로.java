package 구현;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_15671_오델로 {
    static int N;
    static char[][] map;
    static final int SIZE = 6;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static final char BLACK = 'B', WHITE = 'W';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[SIZE + 1][SIZE + 1];
        char horse = BLACK;

        for (int i = 1; i <= SIZE; i++) Arrays.fill(map[i], '.');
        map[3][3] = map[4][4] = WHITE;
        map[3][4] = map[4][3] = BLACK;

        for (int i = 0; i < N; i++) {
            set(horse, sc.nextInt(), sc.nextInt());
            horse = horse == BLACK ? WHITE : BLACK;
        }

        int blackCnt = 0, whiteCnt = 0;

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (map[i][j] == BLACK) blackCnt++;
                else if (map[i][j] == WHITE) whiteCnt++;

                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(blackCnt > whiteCnt ? "Black" : "White");
    }

    static void set(char horse, int x, int y) {
        map[x][y] = horse;

        for (int d = 0; d < 8; d++) {
            int i = x, j = y;
            Stack<int[]> stack = new Stack<>();
            boolean stuck = false;

            while (true) {
                int ni = i + di[d], nj = j + dj[d];

                if (!inRange(ni, nj) || map[ni][nj] == '.') break;
                else if (map[ni][nj] == horse) {
                    stuck = true;
                    break;
                }

                stack.push(new int[]{ni, nj});
                i = ni;
                j = nj;
            }

            if (stuck) {
                while (!stack.isEmpty()) {
                    int[] now = stack.pop();
                    map[now[0]][now[1]] = horse;
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        if (x < 1 || x > SIZE || y < 1 || y > SIZE) return false;
        return true;
    }
}
