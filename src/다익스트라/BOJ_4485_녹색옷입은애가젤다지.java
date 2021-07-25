package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_4485_녹색옷입은애가젤다지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        int TC = 1;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            ArrayList<Edge>[] adj = new ArrayList[N * N];
            int[] dist = new int[N * N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        int from = x * N + y;

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            Edge to = new Edge(nx * N + ny, map[nx][ny]);
                            adj[from].add(to);
                        }
                    }
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, map[0][0]));
            dist[0] = map[0][0];

            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                for (Edge next : adj[now.vertex]) {
                    if (dist[next.vertex] > dist[now.vertex] + next.cost) {
                        dist[next.vertex] = dist[now.vertex] + next.cost;
                        pq.add(next);
                    }
                }
            }

            System.out.println("Problem " + TC++ + ": " + dist[N * N - 1]);
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
            return Integer.compare(this.cost, o.cost);
        }
    }
}
