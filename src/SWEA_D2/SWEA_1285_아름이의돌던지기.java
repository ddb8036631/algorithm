package SWEA_D2;

import java.util.Scanner;

public class SWEA_1285_아름이의돌던지기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] cnt = new int[(int) 1e5];

            for (int i = 0; i < N; i++) {
                int diff = Math.abs(sc.nextInt() - 0);
                cnt[diff]++;
            }

            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > 0) {
                    System.out.println("#" + tc + " " + i + " " + cnt[i]);

                    break;
                }
            }
        }
    }
}
