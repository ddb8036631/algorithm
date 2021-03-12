package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16954_움직이는미로탈출 {
    static final int SIZE = 8;
    static char[][][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new char[SIZE][SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            String s = sc.next();
            for (int j = 0; j < SIZE; j++) {
                map[i][j][0] = s.charAt(j);
            }
        }

        moveWall();

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(7, 0, 0));
        boolean reach = false;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (map[now.x][now.y][now.second >= SIZE ? SIZE - 1 : now.second] == '#') continue;

            if (check(now.x, now.y, now.second) || (now.x == 0 && now.y == SIZE - 1)) {
                reach = true;
                break;
            }

            if (now.second + 1 >= SIZE || map[now.x][now.y][now.second + 1] != '#')
                queue.add(new Point(now.x, now.y, now.second + 1));

            for (int d = 0; d < 8; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!inRange(ny, nx) || map[nx][ny][now.second >= SIZE ? SIZE - 1 : now.second] == '#') continue;

                queue.add(new Point(nx, ny, now.second + 1));
            }
        }

        System.out.println(reach ? 1 : 0);
    }

    static boolean check(int x, int y, int sec) {
        if (x == 0) return true;
        for (int i = x - 1; i >= 0; i--)
            if (map[i][y][sec] == '#') return false;

        return true;
    }

    static void moveWall() {
        for (int sec = 1; sec < SIZE; sec++) {
            for (int j = 0; j < SIZE; j++) {
                for (int i = SIZE - 2; i >= 0; i--) {
                    map[i + 1][j][sec] = map[i][j][sec - 1];
                }
                map[0][j][sec] = '.';
            }
        }
    }

    static boolean inRange(int y, int x) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        return true;
    }

    static class Point {
        int x, y, second;

        public Point(int x, int y, int second) {
            this.x = x;
            this.y = y;
            this.second = second;
        }
    }
}
