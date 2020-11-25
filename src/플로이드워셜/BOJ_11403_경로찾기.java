package 플로이드워셜;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11403_경로찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], 987654321);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                    dist[i][j] = 1;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dist[i][j] != 987654321 ? 1 + " " : 0 + " ");
            }
            System.out.println();
        }
    }
}
