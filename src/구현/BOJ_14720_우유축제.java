package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14720_우유축제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stores = new int[N];
        int idx = 0;
        int answer = 0;
        int[] dp = new int[3];

        for (int i = 0; i < N; i++) stores[i] = sc.nextInt();

        while (stores[idx] != 0) idx++;

        dp[0] = 1;

        for (int i = idx + 1; i < N; i++) {
            int now = stores[i];
            int prev = now - 1 < 0 ? 2 : now - 1;

            if (dp[prev] == 0) continue;

            dp[now] = Math.max(dp[now], dp[prev] + 1);
        }

        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
