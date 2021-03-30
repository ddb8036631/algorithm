package 구현;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BOJ_17144_미세먼지안녕 {
    static int R, C, T;
    static int[][] map;
    static List<Point> airpurifier;
    static Queue<Point> dust;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];
        airpurifier = new ArrayList<>();
        dust = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 0) continue;
                else if (map[i][j] == -1) airpurifier.add(new Point(i, j));
                else dust.add(new Point(i, j));
            }
        }

        int t = 0;

        while (t < T) {
            t++;
            expand();
            rotate();
        }

        int answer = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (map[i][j] > 0) answer += map[i][j];

        System.out.println(answer);
    }

    static void expand() {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++)
            System.arraycopy(map[i], 0, tmp[i], 0, C);

        while (!dust.isEmpty()) {
            Point now = dust.poll();
            int delta = map[now.x][now.y] / 5;

            if (delta == 0) continue;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d], ny = now.y + dy[d];

                if (!inRange(nx, ny) || map[nx][ny] == -1) continue;

                tmp[nx][ny] += delta;
                tmp[now.x][now.y] -= delta;
            }
        }

        map = tmp;
    }

    static void rotate() {
        Point airpurifierUp = airpurifier.get(0);
        Point airpurifierDown = airpurifier.get(1);

        for (int i = airpurifierUp.x; i >= 1; i--) map[i][0] = map[i - 1][0];
        for (int j = 0; j < C - 1; j++) map[0][j] = map[0][j + 1];
        for (int i = 0; i < airpurifierUp.x; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int j = C - 1; j >= 1; j--) map[airpurifierUp.x][j] = map[airpurifierUp.x][j - 1];

        map[airpurifierUp.x][airpurifierUp.y] = -1;
        map[airpurifierUp.x][airpurifierUp.y + 1] = 0;

        for (int i = airpurifierDown.x; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int j = 0; j < C - 1; j++) map[R - 1][j] = map[R - 1][j + 1];
        for (int i = R - 1; i > airpurifierDown.x; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int j = C - 1; j >= 1; j--) map[airpurifierDown.x][j] = map[airpurifierDown.x][j - 1];

        map[airpurifierDown.x][airpurifierDown.y] = -1;
        map[airpurifierDown.x][airpurifierDown.y + 1] = 0;

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (map[i][j] > 0) dust.add(new Point(i, j));
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > R - 1 || y < 0 || y > C - 1) return false;
        return true;
    }
}
