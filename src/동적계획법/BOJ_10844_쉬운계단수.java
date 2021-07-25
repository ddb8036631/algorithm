package 동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10844_쉬운계단수 {
    static int N;
    static int[][] dp;
    static final int MOD = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[10][N + 1];
        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            init();
            answer += go(i, 1);
            answer %= MOD;
        }

        System.out.println(answer);
    }

    static int go(int now, int length) {
        if (length == N) {
            return 1;
        }

        if (dp[now][length] != -1) {
            return dp[now][length];
        }

        int ret = 0;

        if (now - 1 >= 0) {
            ret += go(now - 1, length + 1);
        }

        if (now + 1 <= 9) {
            ret += go(now + 1, length + 1);
        }

        dp[now][length] = ret % MOD;

        return dp[now][length];
    }

    static void init() {
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
