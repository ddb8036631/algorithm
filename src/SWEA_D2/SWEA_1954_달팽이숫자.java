package SWEA_D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#" + tc + "\n");
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int x = 0, y = 0, num = 1, cnt = 0, delta = 1, total = N - 1;

            while (y < N) {
                map[x][y] = num;
                y++;
                num++;
            }

            y--;

            while (num != N * N + 1) {
                while (cnt < total) {
                    x += delta;
                    map[x][y] = num;
                    num++;
                    cnt++;
                }

                cnt = 0;
                delta *= -1;

                while (cnt < total) {
                    y += delta;
                    map[x][y] = num;
                    num++;
                    cnt++;
                }

                cnt = 0;
                total--;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j] + " ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
