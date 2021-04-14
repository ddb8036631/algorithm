package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1939_중량제한 {
    static int N, M;
    static int start, dest;
    static ArrayList<Edge>[] adj;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        int low = 0, high = 1_000_000_000;

        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("low : " + low + ", high : " + high + ", mid : " + mid);

            if (bfs(mid)) {
                low = mid + 1;
                answer = mid;
            } else high = mid - 1;
        }

        System.out.println(answer);
    }

    static boolean bfs(int mid) {
        Arrays.fill(visit, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == dest) return true;

            for (Edge next : adj[now]) {
                if (!visit[next.vertex] && next.cost >= mid) {
                    visit[next.vertex] = true;
                    queue.add(next.vertex);
                }
            }
        }

        return false;
    }

    static class Edge {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
