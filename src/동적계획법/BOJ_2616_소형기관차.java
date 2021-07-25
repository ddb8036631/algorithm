package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2616_소형기관차 {
    static int N, K;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        K = stoi(br.readLine());
        sum = new int[N + 1];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) Arrays.fill(dp[i], -1);
        for (int i = 1; i <= N; i++) sum[i] = sum[i - 1] + arr[i - 1];

        System.out.println(go(1, 0));
    }

    static int go(int idx, int cnt) {
        if (cnt == 3) return 0;
        if (idx >= N) return 0;
        if (dp[idx][cnt] != -1) return dp[idx][cnt];
        if (idx + K - 1 <= N)
            dp[idx][cnt] = Math.max(go(idx + 1, cnt), sum[idx + K - 1] - sum[idx - 1] + go(idx + K, cnt + 1));

        return dp[idx][cnt];
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
