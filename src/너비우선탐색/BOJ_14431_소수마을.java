package 너비우선탐색;

import java.util.*;

public class BOJ_14431_소수마을 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] sosu = new boolean[9001];
        Arrays.fill(sosu, true);
        sosu[0] = false;
        sosu[1] = false;
        for (int i = 2; i <= 9000; i++) {
            for (int j = i + i; j <= 9000; j += i) {
                sosu[j] = false;
            }
        }

        int si = sc.nextInt();
        int sj = sc.nextInt();
        int di = sc.nextInt();
        int dj = sc.nextInt();

        int N = sc.nextInt();

        Point[] points = new Point[N + 2];
        int[] dist = new int[N + 2];
        Arrays.fill(dist, 987654321);
        List<Edge>[] adj = new ArrayList[N + 2];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList<>();

        points[0] = new Point(si, sj);
        points[N + 1] = new Point(di, dj);
        for (int i = 1; i <= N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        for (int from = 0; from < N + 2; from++) {
            for (int to = 0; to < N + 2; to++) {
                if (from == to) continue;
                int distance = (int) Math.floor(Math.sqrt(Math.pow(Math.abs(points[from].i - points[to].i), 2) + Math.pow(Math.abs(points[from].j - points[to].j), 2)));
                if (sosu[distance]) {
                    adj[from].add(new Edge(to, distance));
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.offer(new Edge(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge next : adj[now.vertex]) {
                if (dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    pq.offer(new Edge(next.vertex, dist[next.vertex]));
                }

            }
        }

        System.out.println(dist[N + 1] == 987654321 ? -1 : dist[N + 1]);
    }

    public static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
