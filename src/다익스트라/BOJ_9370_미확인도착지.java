package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9370_미확인도착지 {
    static int n, m, t, s, g, h;
    static ArrayList<Edge>[] adj;
    static Info[] infos;
    static boolean[] visit;
    static TreeMap<Integer, Boolean> candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                adj[i] = new ArrayList<>();

            infos = new Info[n + 1];
            for (int i = 1; i <= n; i++)
                infos[i] = new Info(Integer.MAX_VALUE, false);

            visit = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1, v2, cost;

                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());

                adj[v1].add(new Edge(v2, cost));
                adj[v2].add(new Edge(v1, cost));
            }

            candidate = new TreeMap<>();
            for (int i = 0; i < t; i++)
                candidate.put(Integer.parseInt(br.readLine()), false);

            PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.cost - o2.cost;
                }
            });

            infos[s].dist = 0;
            Edge start = new Edge(s, 0);
            pq.add(start);

            while (!pq.isEmpty()) {
                Edge now = pq.poll();
                visit[now.vertex] = true;

                if (candidate.containsKey(now.vertex) && infos[now.vertex].used) {
                    candidate.put(now.vertex, true);
                }

                for (Edge next : adj[now.vertex]) {
                    if (!visit[next.vertex] && infos[next.vertex].dist >= infos[now.vertex].dist + next.cost) {
                        if(infos[next.vertex].used && infos[next.vertex].dist == infos[now.vertex].dist + next.cost) continue;

                        infos[next.vertex].dist = infos[now.vertex].dist + next.cost;
                        infos[next.vertex].used = infos[now.vertex].used;

                        Edge edge = new Edge(next.vertex, infos[next.vertex].dist);

                        pq.add(edge);

                        if ((now.vertex == g && next.vertex == h) || (now.vertex == h && next.vertex == g)) {
                            infos[next.vertex].used = true;
                        }
                    }
                }
            }

            for (Map.Entry entry : candidate.entrySet()) {
                if ((boolean) entry.getValue()) {
                    System.out.print(entry.getKey() + " ");
                }
            }
            System.out.println();
        }
    }

    private static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    private static class Info {
        int dist;
        boolean used;

        public Info(int dist, boolean used) {
            this.dist = dist;
            this.used = used;
        }
    }
}
