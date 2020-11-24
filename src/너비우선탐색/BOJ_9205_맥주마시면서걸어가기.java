package 너비우선탐색;

import java.util.*;

public class BOJ_9205_맥주마시면서걸어가기 {
    static int N;
    static int[][] dist;
    static boolean[] visit;
    static Point[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();

            dist = new int[N + 2][N + 2];
            visit = new boolean[N + 2];
            points = new Point[N + 2];

            for (int i = 0; i < N + 2; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();

                points[i] = new Point(y, x);
            }

            for (int from = 0; from < N + 2; from++) {
                for (int to = 0; to < N + 2; to++) {
                    dist[from][to] = Math.abs(points[from].y - points[to].y) + Math.abs(points[from].x - points[to].x);
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            visit[0] = true;
            queue.add(0);
            boolean flag = false;

            while (!queue.isEmpty()) {
                int from = queue.poll();

                if (from == N + 1) {
                    flag = true;
                    break;
                }

                for (int to = 0; to < N + 2; to++) {
                    if (from != to && !visit[to] && dist[from][to] <= 1000) {
                        visit[to] = true;
                        queue.add(to);
                    }
                }
            }
            System.out.println(flag ? "happy" : "sad");
        }
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
