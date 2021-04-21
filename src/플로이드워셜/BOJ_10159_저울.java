package 플로이드워셜;

import java.util.Scanner;

public class BOJ_10159_저울 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = true;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] && map[k][j]) map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (!map[i][j] && !map[j][i]) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
