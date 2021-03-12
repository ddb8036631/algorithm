package 다익스트라;

import java.util.*;

public class BOJ_10217_KCMTravel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N, M, K;
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            ArrayList<Edge>[] adj = new ArrayList[N + 1];
            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < K; i++) {
                int u, v, c, d;
                u = sc.nextInt();
                v = sc.nextInt();
                c = sc.nextInt();
                d = sc.nextInt();

                adj[u].add(new Edge(v, c, d));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.time - o2.time;
                }
            });

            dp[1][0] = 0;
            pq.add(new Edge(1, 0, 0));
            int answer = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                if(now.vertex == N) {
                    answer = now.time;
                    break;
                }

                for (Edge next : adj[now.vertex]) {
                    if (now.cost + next.cost > M) continue;

                    if (dp[next.vertex][now.cost + next.cost] > now.time + next.time) {
                        dp[next.vertex][now.cost + next.cost] = now.time + next.time;
                        pq.add(new Edge(next.vertex, now.cost + next.cost, dp[next.vertex][now.cost + next.cost]));
                    }
                }
            }

            System.out.println(answer == Integer.MAX_VALUE ? "Poor KCM" : answer);
        }
    }

    static class Edge {
        int vertex, cost, time;

        public Edge(int vertex, int cost, int time) {
            this.vertex = vertex;
            this.cost = cost;
            this.time = time;
        }
    }
}
