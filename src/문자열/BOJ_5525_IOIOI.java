package 문자열;

import java.util.Scanner;

public class BOJ_5525_IOIOI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();

        int[] cnt = new int[M];
        int ans = 0;
        for (int i = 2; i < M; i++) {
            if (S.substring(i - 2, i + 1).equals("IOI")) {
                cnt[i] = cnt[i - 2] + 1;
            }

            if (cnt[i] >= N) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
