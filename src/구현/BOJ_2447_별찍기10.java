package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별찍기10 {
    static char[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(map[i], ' ');

        solve(N, N / 2, N / 2);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solve(int n, int x, int y) {
        if (n == 3) {
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                map[nx][ny] = '*';
            }

            return;
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d] * n / 3, ny = y + dy[d] * n / 3;
            solve(n / 3, nx, ny);
        }
    }
}
