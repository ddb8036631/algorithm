package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1107_리모컨 {
    static int N, M;
    static boolean[] remocon;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        ans = Math.abs(N - 100);

        remocon = new boolean[10];
        Arrays.fill(remocon, true);

        for (int i = 0; i < M; i++)
            remocon[sc.nextInt()] = false;

        if (N == 100)
            System.out.println(0);
        else {
            solve(0, new StringBuilder());
            System.out.println(ans);
        }
    }

    private static void solve(int depth, StringBuilder sb) {
        if (!sb.toString().equals("")) {
            int diff = Math.abs(N - Integer.parseInt(sb.toString()));
            int len = sb.length() + diff;

            ans = Math.min(ans, len);
        }

        if (depth == Integer.toString(N).length() + 1) {
            return;
        }

        for (int i = 0; i < remocon.length; i++) {
            if (remocon[i]) {
                sb.append(i);
                solve(depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
