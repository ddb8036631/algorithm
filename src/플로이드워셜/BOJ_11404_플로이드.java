package 플로이드워셜;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11404_플로이드 {
    static int N, M;
    static int[][] dist;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < M; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dist[i][j] == INF ? "0 " : dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
