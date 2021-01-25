package 그래프;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BOJ_14466_소가길을건너간이유6 {
    static int N, K, R;
    static Point[] k;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<Integer>[] adj;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        R = sc.nextInt();

        adj = new ArrayList[N * N + 1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            int from = convert(sc.nextInt(), sc.nextInt());
            int to = convert(sc.nextInt(), sc.nextInt());

            adj[from].add(to);
            adj[to].add(from);
        }

        k = new Point[K];
        for (int i = 0; i < K; i++) {
            k[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < K - 1; i++) {
            for (int j = i + 1; j < K; j++) {
                Point from = new Point(k[i].x, k[i].y);
                Point to = new Point(k[j].x, k[j].y);

                bfs(from, to);
            }
        }

        System.out.println(answer);
    }

    static void bfs(Point start, Point dest) {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N * N + 1];

        queue.add(start);
        visit[convert(start.x, start.y)] = true;

        boolean reachWithoutRoad = false;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == dest.x && now.y == dest.y) {
                reachWithoutRoad = true;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int next_i = now.x + di[d];
                int next_j = now.y + dj[d];

                int from = convert(now.x, now.y);
                int to = convert(next_i, next_j);

                if (next_i < 1 || next_i > N || next_j < 1 || next_j > N || visit[convert(next_i, next_j)] || adj[from].contains(to))
                    continue;

                queue.add(new Point(next_i, next_j));
                visit[convert(next_i, next_j)] = true;
            }
        }

        if (!reachWithoutRoad) {
            answer++;
        }
    }

    static int convert(int x, int y) {
        return (x - 1) * N + y;
    }
}
