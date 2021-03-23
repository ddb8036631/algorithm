package 너비우선탐색;

import java.util.*;

public class BOJ_4179_불 {
    static int R, C;
    static char[][] map;
    static int[][] fire;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] J;
    static ArrayList<int[]> F;
    static final int MAX = 987654321;
    static int answer = MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        fire = new int[R][C];
        visit = new boolean[R][C];
        F = new ArrayList<>();

        for (int i = 0; i < R; i++) Arrays.fill(fire[i], MAX);

        for (int i = 0; i < R; i++) {
            String s = sc.next();

            for (int j = 0; j < C; j++) {
                char ch = s.charAt(j);
                map[i][j] = ch;

                if (ch == 'J') J = new int[]{i, j};
                else if (ch == 'F') {
                    F.add(new int[]{i, j});
                    fire[i][j] = 0;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int[] f : F) queue.add(new Point(f[0], f[1], 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d], ny = now.y + dy[d];

                if (!inRange(nx, ny) || now.time + 1 >= fire[nx][ny] || map[nx][ny] == '#') continue;

                fire[nx][ny] = now.time + 1;
                queue.add(new Point(nx, ny, now.time + 1));
            }
        }

        visit[J[0]][J[1]] = true;
        queue.add(new Point(J[0], J[1], 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1) {
                answer = now.time + 1;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d], ny = now.y + dy[d];

                if (!inRange(nx, ny) || visit[nx][ny] || map[nx][ny] == '#' || now.time + 1 >= fire[nx][ny]) continue;

                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, now.time + 1));
            }
        }

        System.out.println(answer == MAX ? "IMPOSSIBLE" : answer);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > R - 1 || y < 0 || y > C - 1) return false;
        return true;
    }

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
