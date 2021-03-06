package 다익스트라;

import java.util.*;

public class BOJ_1916_최소비용구하기 {
    static int N, M;
    static List<Edge>[] adj;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u, v, w;
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();

            adj[u].add(new Edge(v, w));
        }

        int start = sc.nextInt();
        int dest = sc.nextInt();

        dist = new int[N + 1];
        Arrays.fill(dist, 987654321);

        visit = new boolean[N + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            visit[now.vertex] = true;

            for (Edge next : adj[now.vertex]) {
                if (!visit[next.vertex] && dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        System.out.println(dist[dest]);
    }

    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
