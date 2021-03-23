package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562_나이트의이동 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}, dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int l = sc.nextInt();
            boolean[][] visit = new boolean[l][l];
            Point start = new Point(sc.nextInt(), sc.nextInt(), 0);
            Point end = new Point(sc.nextInt(), sc.nextInt(), 0);

            int answer = 0;

            Queue<Point> queue = new LinkedList<>();
            visit[start.x][start.y] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (now.x == end.x && now.y == end.y) {
                    answer = now.cnt;
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int nx = now.x + dx[d], ny = now.y + dy[d];
                    if (nx < 0 || nx > l - 1 || ny < 0 || ny > l - 1 || visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, now.cnt + 1));
                }
            }

            System.out.println(answer);
        }
    }

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
