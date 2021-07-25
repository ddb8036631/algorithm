package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_사탕게임 {
    static int N;
    static char[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) cnt++;
                else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }

            max = Math.max(max, cnt);
        }

        for (int j = 0; j < N; j++) {
            int cnt = 1;

            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] == map[i + 1][j]) cnt++;
                else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }

            max = Math.max(max, cnt);
        }
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }
}
