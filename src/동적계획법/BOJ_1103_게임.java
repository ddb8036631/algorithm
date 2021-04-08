package 동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1103_게임 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        dp = new int[N][M];

        for (int[] arr : dp) Arrays.fill(arr, -1);

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map[i][j] = c - '0' <= 9 ? c - '0' : 0;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (!inRange(x, y) || map[x][y] == 0) return 0;
        if (visit[x][y]) {
            System.out.println(-1);
            System.exit(0);
        }
        if (dp[x][y] != -1) return dp[x][y];

        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d] * map[x][y], ny = y + dy[d] * map[x][y];
            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }

        visit[x][y] = false;

        return dp[x][y];
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1) return false;
        return true;
    }
}
