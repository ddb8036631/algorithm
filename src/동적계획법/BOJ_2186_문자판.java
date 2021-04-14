package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2186_문자판 {
    static int N, M, K;
    static char[][] map;
    static int[][][] dp;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        target = br.readLine().toCharArray();
        dp = new int[N][M][target.length];

        for (int[][] arr : dp) {
            for (int[] arrr : arr) {
                Arrays.fill(arrr, -1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == target[0]) {
                    answer += dfs(i, j, 0);
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y, int now) {
        if (dp[x][y][now] != -1) return dp[x][y][now];
        if (now == target.length - 1) return dp[x][y][now] = 1;

        dp[x][y][now] = 0;

        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nx = x + dx[d] * k, ny = y + dy[d] * k;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == target[now + 1]) dp[x][y][now] += dfs(nx, ny, now + 1);
            }
        }

        return dp[x][y][now];
    }
}
