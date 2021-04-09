package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기_TD {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, 0, 1}, dy = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int[] arr : dp) Arrays.fill(arr, -1);

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];
        if (x == N - 1 && y == M - 1) return map[x][y];

        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d], ny = y + dy[d];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;

            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + map[x][y]);
        }

        return dp[x][y];
    }
}
