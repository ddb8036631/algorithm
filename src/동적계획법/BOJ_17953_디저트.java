package 동적계획법;

import java.util.Scanner;

public class BOJ_17953_디저트 {
    static int N, M;
    static int[][] dessert;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dessert = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                dessert[i][j] = sc.nextInt();

        for (int i = 0; i < dessert.length; i++) {
            dp[i][0] = dessert[i][0];
        }

        for (int day = 1; day < N; day++) {
            for (int type = 0; type < M; type++) {
                for (int eachType = 0; eachType < M; eachType++) {
                    if (eachType == type)
                        dp[type][day] = Math.max(dp[type][day], dp[eachType][day - 1] + dessert[type][day] / 2);
                    else
                        dp[type][day] = Math.max(dp[type][day], dp[eachType][day - 1] + dessert[type][day]);

                }
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) answer = Math.max(answer, dp[i][N - 1]);

        System.out.println(answer);
    }
}

