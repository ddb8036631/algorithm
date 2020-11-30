package SWEA_모의SW역량테스트;

import java.util.Scanner;

public class SWEA_1952_수영장 {
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            ans = Integer.MAX_VALUE;
            int[] fee = new int[4];
            for (int i = 0; i < 4; i++)
                fee[i] = sc.nextInt();

            int[] months = new int[12];
            for (int i = 0; i < 12; i++)
                months[i] = sc.nextInt();

            calc(fee, months, 0, 0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void calc(int[] fee, int[] months, int idx, int sum) {
        if (idx > 11) {
            ans = Math.min(ans, sum);
            return;
        }

        calc(fee, months, idx + 1, sum + months[idx] * fee[0]);
        calc(fee, months, idx + 1, sum + fee[1]);
        calc(fee, months, idx + 3, sum + fee[2]);
        calc(fee, months, idx + 12, fee[3]);
    }
}
