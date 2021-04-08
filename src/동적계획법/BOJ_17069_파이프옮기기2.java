package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17069_파이프옮기기2 {
    static int N;
    static int[][] map;
    static long[][][] dp;
    static final int HORIZONTAL = 0, DIAGONAL = 1, VERTICAL = 2;
    static int[] dx = {0, 1, 1}, dy = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N][3];

        for (int i = 0; i < N; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(dfs(0, 1, HORIZONTAL));
    }

    static long dfs(int x, int y, int dir) {
        if (dp[x][y][dir] != 0) return dp[x][y][dir];
        if (x == N - 1 && y == N - 1) return 1;

        for (int d = 0; d < 3; d++) {
            if (dir == HORIZONTAL && d == VERTICAL) continue;
            if (dir == VERTICAL && d == HORIZONTAL) continue;

            int nx = x + dx[d], ny = y + dy[d];

            if (!inRange(nx, ny) || map[nx][ny] == 1) continue;
            if (d == DIAGONAL && (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)) continue;

            dp[x][y][dir] += dfs(nx, ny, d);
        }

        return dp[x][y][dir];
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1) return false;
        return true;
    }
}

