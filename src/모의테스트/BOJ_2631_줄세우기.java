package 모의테스트;

import java.util.Scanner;

public class BOJ_2631_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) max = Math.max(max, dp[i]);

        System.out.println(N - max);
    }
}
