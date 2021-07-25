package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2448_별찍기11 {
    static char[][] map;
    static int[] dx = {-1, 0, 0, 1, 1, 1, 1, 1}, dy = {0, -1, 1, -2, -1, 0, 1, 2};
    static int[] ddx = {-2, 1, 1}, ddy = {0, -3, 3};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) Arrays.fill(map[i], ' ');

        solve(N, N / 2, N - 1);

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                answer.append(map[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    static void solve(int n, int x, int y) {
        if (n == 3) {
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                map[nx][ny] = '*';
            }

            return;
        } else if (n == 6) {
            for (int d = 0; d < 3; d++) {
                int nx = x + ddx[d], ny = y + ddy[d];
                solve(n / 2, nx, ny);
            }
        } else {
            solve(n / 2, x - n / 4, y);
            solve(n / 2, x + n / 4, y - n / 2);
            solve(n / 2, x + n / 4, y + n / 2);
        }
    }
}
