package 동적계획법;

import java.util.Scanner;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] d = new int[N][3];
        d[0] = cost[0].clone();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    min = Math.min(min, d[i - 1][k]);
                }
                d[i][j] = min + cost[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++)
            answer = Math.min(answer, d[N - 1][j]);

        System.out.println(answer);
    }
}
