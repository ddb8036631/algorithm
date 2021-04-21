package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11052_카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        dp[0] = cost[0];

        for (int i = 1; i < N; i++) {
            dp[i] = cost[i];

            for (int j = i - 1; j >= (i - 1) / 2; j--) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j - 1]);
            }
        }

        System.out.println(dp[N - 1]);
    }
}
