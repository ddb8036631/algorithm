package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14442_벽부수고이동하기2 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        visit[0][0][0] = true;
        queue.add(new Point(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                answer = now.dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!inRange(nx, ny)) continue;

                if (map[nx][ny] == 0 && !visit[nx][ny][now.cnt]) {
                    visit[nx][ny][now.cnt] = true;
                    queue.add(new Point(nx, ny, now.dist + 1, now.cnt));
                }

                if (map[nx][ny] == 1 && now.cnt + 1 <= K && !visit[nx][ny][now.cnt + 1]) {
                    visit[nx][ny][now.cnt + 1] = true;
                    queue.add(new Point(nx, ny, now.dist + 1, now.cnt + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1) return false;
        return true;
    }

    static class Point {
        int x, y, dist, cnt;

        public Point(int x, int y, int dist, int cnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cnt = cnt;
        }
    }
}
