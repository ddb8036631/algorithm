package SWEA_D2;

import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            sc.nextInt();

            int[] cnt = new int[101];
            int[] scores = new int[1000];

            for (int i = 0; i < 1000; i++) {
                scores[i] = sc.nextInt();
                cnt[scores[i]]++;
            }

            int maxScore = 0;
            int maxCnt = 0;

            for (int i = 0; i <= 100; i++) {
                if (maxCnt <= cnt[i]) {
                    maxCnt = Math.max(maxCnt, cnt[i]);
                    maxScore = Math.max(maxScore, i);
                }
            }

            System.out.println("#" + tc + " " + maxScore);
        }
    }
}
