package 구현;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2151_거울설치 {
    static int N;
    static char[][] map;
    static int[][][] visit;
    static Point start, end;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visit = new int[N][N][4];
        boolean first = true;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#') {
                    if (first) {
                        start = new Point(i, j);
                        first = false;
                    } else end = new Point(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Point> queue = new LinkedList<>();

        for (int d = 0; d < 4; d++) {
            visit[start.x][start.y][d] = 0;
            queue.add(new Point(start.x, start.y, d));
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];

            if (!inRange(nx, ny) || map[nx][ny] == '*') continue;

            if (map[nx][ny] == '.') {
                if (visit[nx][ny][now.dir] > visit[now.x][now.y][now.dir]) {
                    visit[nx][ny][now.dir] = visit[now.x][now.y][now.dir];
                    queue.add(new Point(nx, ny, now.dir));
                }
            } else if (map[nx][ny] == '#') {
                if (visit[nx][ny][now.dir] > visit[now.x][now.y][now.dir])
                    visit[nx][ny][now.dir] = visit[now.x][now.y][now.dir];
            } else if (map[nx][ny] == '!') {
                if (visit[nx][ny][now.dir] > visit[now.x][now.y][now.dir]) {
                    visit[nx][ny][now.dir] = visit[now.x][now.y][now.dir];
                    queue.add(new Point(nx, ny, now.dir));
                }

                int[] next_dir = changeDir(now.dir);

                if (visit[nx][ny][next_dir[0]] > visit[now.x][now.y][now.dir] + 1) {
                    visit[nx][ny][next_dir[0]] = visit[now.x][now.y][now.dir] + 1;
                    queue.add(new Point(nx, ny, next_dir[0]));
                }

                if (visit[nx][ny][next_dir[1]] > visit[now.x][now.y][now.dir] + 1) {
                    visit[nx][ny][next_dir[1]] = visit[now.x][now.y][now.dir] + 1;
                    queue.add(new Point(nx, ny, next_dir[1]));
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, visit[end.x][end.y][d]);
        }

        System.out.println(answer);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1) return false;
        return true;
    }

    static int[] changeDir(int dir) {
        if (dir == 0 || dir == 1) return new int[]{2, 3};
        else return new int[]{0, 1};
    }

    static class Point {
        int x, y, dir;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
