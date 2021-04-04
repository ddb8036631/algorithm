package 동적계획법;

import java.util.Scanner;

public class BOJ_13703_물벼룩의생존확률 {
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        dp = new long[63 * 2 + 1][n + 1];

        solve(k, n);

        System.out.println(dp[k][n]);
    }

    static long solve(int depth, int time) {
        if (dp[depth][time] != 0) return dp[depth][time];

        if (depth == 0) return 0;
        else if (time == 0) return 1;

        return dp[depth][time] = solve(depth - 1, time - 1) + solve(depth + 1, time - 1);
    }
}
