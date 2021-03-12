package 동적계획법;

import java.util.Scanner;

public class BOJ_1890_점프 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) continue;

                if (inRange(i, j + map[i][j])) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }

                if (inRange(i + map[i][j], j)) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1) return false;
        return true;
    }
}
