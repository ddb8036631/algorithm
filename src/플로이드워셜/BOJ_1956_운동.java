package 플로이드워셜;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1956_운동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        final int MAX = 987654321;
        int[][] dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) Arrays.fill(dist[i], MAX);

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (i == k) continue;
                for (int j = 1; j <= V; j++) {
                    if (j == k || j == i) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int answer = MAX;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                if (dist[i][j] != MAX && dist[j][i] != MAX) {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }

        System.out.println(answer == MAX ? -1 : answer);
    }
}
