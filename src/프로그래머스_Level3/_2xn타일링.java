package 프로그래머스_Level3;

public class _2xn타일링 {
    public static long solution(int n) {
        final int MOD = 1_000_000_007;

        if (n <= 2) return n;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
