package 다익스트라;

import java.util.*;

public class BOJ_1753_최단경로 {
    static int V, E, K;
    static int[] dist;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        dist = new int[V + 1];
        used = new boolean[V + 1];

        List<Edge>[] adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = 987654321;
        }

        for (int i = 0; i < E; i++) {
            int u, v, w;
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();

            adj[u].add(new Edge(v, w));
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        dist[K] = 0;
        pq.add(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            used[now.vertex] = true;

            for (Edge next : adj[now.vertex]) {
                if (!used[next.vertex] && dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++)
            System.out.println(dist[i] == 987654321 ? "INF" : dist[i]);
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
