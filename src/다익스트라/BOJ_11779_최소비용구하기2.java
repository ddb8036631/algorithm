package 다익스트라;

import java.util.*;

public class BOJ_11779_최소비용구하기2 {
    static int N, M, start, end;
    static final int MAX = 987654321;
    static ArrayList<Edge>[] adj;
    static int[] dist;
    static int[] parent;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        parent = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) dist[i] = MAX;
        for (int i = 0; i < M; i++) adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));

        start = sc.nextInt();
        end = sc.nextInt();

        dijkstra();

        int x = end;
        Stack<Integer> stack = new Stack<>();

        while (x != parent[x]) {
            stack.push(x);
            x = parent[x];
        }

        System.out.println(dist[end]);
        System.out.println(stack.size());
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge next : adj[now.vertex]) {
                if (dist[next.vertex] > dist[now.vertex] + next.cost) {
                    dist[next.vertex] = dist[now.vertex] + next.cost;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));

                    parent[next.vertex] = now.vertex;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
