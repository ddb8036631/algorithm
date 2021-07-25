package 모의테스트;

import java.util.Scanner;

public class BOJ_11985_오렌지출하 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[] size = new int[N + 1];
        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) size[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            dp[i] = Long.MAX_VALUE;
            long max = size[i], min = size[i];

            for (int j = i; j >= Integer.max(1, i - M + 1); j--) {
                max = Math.max(max, size[j]);
                min = Math.min(min, size[j]);
                dp[i] = Math.min(dp[i], dp[j - 1] + K + (i - j + 1) * (max - min));
            }
        }

        System.out.println(dp[N]);
    }
}
