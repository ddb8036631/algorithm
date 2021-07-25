package 모의테스트;

import java.util.Scanner;

public class BOJ_14718_용감한용사진수 {
    static int N, K;
    static int[][] stats;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        stats = new int[N][3];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            stats[i][0] = sc.nextInt();
            stats[i][1] = sc.nextInt();
            stats[i][2] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int n = 0; n < N; n++) {
                        if (stats[i][0] >= stats[n][0] && stats[j][1] >= stats[n][1] && stats[k][2] >= stats[n][2]) {
                            cnt++;
                        }
                    }

                    if (cnt >= K) min = Math.min(min, stats[i][0] + stats[j][1] + stats[k][2]);
                }
            }
        }

        System.out.println(min);
    }
}
