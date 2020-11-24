package SWEA_D2;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += map[k][l];
                        }
                    }

                    ans = Math.max(ans, sum);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
