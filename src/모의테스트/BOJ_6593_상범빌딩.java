package 모의테스트;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_6593_상범빌딩 {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0, 0, 0}, dy = {0, 0, -1, 1, 0, 0}, dz = {0, 0, 0, 0, -1, 1};
    static Point start, dest;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[R][C][L];
            visit = new boolean[R][C][L];
            Queue<Point> queue = new LinkedList<>();

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String s = sc.next();

                    for (int c = 0; c < C; c++) {
                        char ch = s.charAt(c);
                        map[r][c][l] = ch;

                        if (ch == 'S') {
                            start = new Point(r, c, l);
                            map[r][c][l] = '.';
                        } else if (ch == 'E') {
                            dest = new Point(r, c, l);
                            map[r][c][l] = '.';
                        }
                    }
                }
            }

            visit[start.r][start.c][start.l] = true;
            queue.add(start);
            int time = 0;
            boolean found = false;

            outer:
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int s = 0; s < size; s++) {
                    Point now = queue.poll();

                    if (now.equals(dest)) {
                        found = true;
                        break outer;
                    }

                    for (int d = 0; d < 6; d++) {
                        int nx = now.r + dx[d], ny = now.c + dy[d], nz = now.l + dz[d];

                        if (!isInRange(nx, ny, nz) || visit[nx][ny][nz] || map[nx][ny][nz] == '#') continue;

                        visit[nx][ny][nz] = true;
                        queue.add(new Point(nx, ny, nz));
                    }
                }

                time++;
            }

            System.out.println(found ? "Escaped in " + time + " minute(s)." : "Trapped!");
        }

    }

    static boolean isInRange(int x, int y, int z) {
        return x >= 0 && x < R && y >= 0 && y < C && z >= 0 && z < L;
    }

    static class Point {
        int r, c, l;

        public Point(int r, int c, int l) {
            this.r = r;
            this.c = c;
            this.l = l;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "l=" + l +
                    ", r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c && l == point.l;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, l);
        }
    }
}
