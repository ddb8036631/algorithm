package SWEA_D2;

import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] cost = new int[N];

            for (int i = 0; i < N; i++) cost[i] = sc.nextInt();

            int max = cost[N - 1];
            long sum = 0;

            for (int i = N - 2; i >= 0; i--) {
                if (cost[i] > max) max = cost[i];
                else sum += max - cost[i];
            }

            System.out.println("#" + tc + " " + sum);
        }
    }
}
