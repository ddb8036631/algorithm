package 동적계획법;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_11066_파일합치기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            int K = sc.nextInt();
            int[] novels = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            int[] sum = new int[K + 1];

            for (int i = 1; i <= K; i++) {
                int num = sc.nextInt();
                novels[i] = num;
                sum[i] = sum[i - 1] + num;
            }

            for (int d = 1; d < K; d++) {
                for (int x = 1; x + d <= K; x++) {
                    int y = x + d;
                    dp[x][y] = Integer.MAX_VALUE;

                    for (int mid = x; mid < y; mid++) {
                        dp[x][y] = Math.min(dp[x][y], dp[x][mid] + dp[mid + 1][y] + sum[y] - sum[x - 1]);
                    }
                }
            }
        }
    }
}
