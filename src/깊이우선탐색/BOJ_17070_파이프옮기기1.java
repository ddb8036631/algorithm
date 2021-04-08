package 깊이우선탐색;

import java.util.Scanner;

public class BOJ_17070_파이프옮기기1 {
    static int N;
    static final int HORIZONTAL = 0, DIAGONAL = 1, VERTICAL = 2;
    static int[] dx = {0, 1, 1}, dy = {1, 1, 0};
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        dfs(0, 1, HORIZONTAL);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }

        for (int d = 0; d < 3; d++) {
            if (dir == HORIZONTAL && d == VERTICAL) continue;
            if (dir == VERTICAL && d == HORIZONTAL) continue;

            int nx = x + dx[d], ny = y + dy[d];

            if (!inRange(nx, ny) || map[nx][ny] == 1) continue;
            if (d == DIAGONAL && (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)) continue;

            dfs(nx, ny, d);
        }
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1) return false;
        return true;
    }
}
