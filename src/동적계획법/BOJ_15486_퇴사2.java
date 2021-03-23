package 동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15486_퇴사2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            if (i == N) break;
            if (i + T[i] <= N) dp[i + T[i]] = Math.max(dp[i + T[i]], max + P[i]);
        }

        System.out.println(max);
    }
}
