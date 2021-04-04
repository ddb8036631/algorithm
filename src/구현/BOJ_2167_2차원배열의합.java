package 구현;

import java.util.Scanner;

public class BOJ_2167_2차원배열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                arr[i][j] = sc.nextInt();

        int K = sc.nextInt();

        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum = 0;
            for (int a = i; a <= x; a++) {
                for (int b = j; b <= y; b++) {
                    sum += arr[a][b];
                }
            }

            System.out.println(sum);
        }
    }
}
