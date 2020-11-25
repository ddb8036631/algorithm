package 동적계획법;

import java.util.Scanner;

public class BOJ_9461_파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            if (N <= 3) {
                System.out.println(1);
                continue;
            } else if (N <= 5) {
                System.out.println(2);
                continue;
            }

            long[] memo = new long[N + 1];
            memo[1] = memo[2] = memo[3] = 1;
            memo[4] = memo[5] = 2;

            for (int i = 6; i <= N; i++) {
                memo[i] = memo[i - 5] + memo[i - 1];
            }

            System.out.println(memo[N]);
        }
    }
}
