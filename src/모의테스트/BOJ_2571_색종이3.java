package 모의테스트;

import java.util.Scanner;

public class BOJ_2571_색종이3 {
    static final int SIZE = 100;
    static int[][] map;
    static int answer = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[SIZE][SIZE];

        for (int n = 0; n < N; n++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int x = a; x < a + 10; x++)
                for (int y = b; y < b + 10; y++)
                    map[x][y]++;
        }

        for (int sx = 0; sx < SIZE - 1; sx++) {
            for (int sy = 0; sy < SIZE - 1; sy++) {
                if (map[sx][sy] == 0) continue;

                for (int ex = sx + 1; ex < SIZE; ex++) {
                    for (int ey = sy + 1; ey < SIZE; ey++) {
                        if (map[ex][ey] == 0) break;

                        int now = (ex - sx + 1) * (ey - sy + 1);

                        if (now <= answer) continue;
                        if (check(sx, sy, ex, ey))
                            answer = Math.max(answer, now);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(int sx, int sy, int ex, int ey) {
        for (int x = sx; x <= ex; x++)
            for (int y = sy; y <= ey; y++)
                if (map[x][y] == 0) return false;

        return true;
    }
}
