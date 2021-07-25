package 최장증가부분수열;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2565_전깃줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] pairs = new Pair[N];
        int[] dp = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) pairs[i] = new Pair(sc.nextInt(), sc.nextInt());

        Arrays.sort(pairs, (o1, o2) -> o1.start - o2.start);

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (pairs[j].start < pairs[i].start && pairs[j].end < pairs[i].end && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        for (int i = 0; i < N; i++) cnt = Math.max(cnt, dp[i]);

        System.out.println(Arrays.toString(dp));
        System.out.println(N - cnt);
    }

    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
