package 모의테스트;

import java.util.*;

public class BOJ_17616_등수찾기 {
    static int N, M, K;
    static ArrayList<Integer>[][] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        adj = new ArrayList[2][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[0][b].add(a);
            adj[1][a].add(b);
        }

        int U = bfs(0);
        Arrays.fill(visit, false);
        int V = N - bfs(1) + 1;

        System.out.println(U + " " + V);
    }

    static int bfs(int dir) {
        Queue<Integer> q = new LinkedList<>();
        visit[K] = true;
        q.add(K);
        int cnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            cnt++;

            for (int next : adj[dir][now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }

        return cnt;
    }
}
