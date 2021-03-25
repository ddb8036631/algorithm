package 동적계획법;

import java.util.Scanner;

public class BOJ_1932_정수삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        int cnt = 1;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cnt; j++) {
                map[i][j] = sc.nextInt();
            }
            cnt++;
        }

        dp[0][0] = map[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j - 1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + map[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + map[i][j]);
            }
        }

        for (int j = 0; j < N; j++) answer = Math.max(answer, dp[N - 1][j]);

        System.out.println(answer);
    }
}
