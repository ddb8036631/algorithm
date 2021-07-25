package 동적계획법;

import java.util.Scanner;

public class BOJ_1904_01타일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        final int MOD = 15746;

        if (N <= 2) {
            System.out.println(N);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;

        System.out.println(dp[N]);
    }
}
