package 플로이드워셜;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14938_서강그라운드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[] items = new int[N + 1];
        int[][] adj = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) items[i] = sc.nextInt();
        for (int i = 1; i <= N; i++) Arrays.fill(adj[i], 987654321);

        for (int r = 0; r < R; r++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            adj[u][v] = adj[v][u] = cost;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;

                for (int j = 1; j <= N; j++) {
                    if (j == i || j == k) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = items[i];

            for (int j = 1; j <= N; j++) {
                if (adj[i][j] <= M) {
                    cnt += items[j];
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
