package 트리;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11437_LCA {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] depth;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        visit = new boolean[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        dfs(1, 0);

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            System.out.println(lca(sc.nextInt(), sc.nextInt()));
        }
    }

    private static void dfs(int from, int d) {
        visit[from] = true;
        depth[from] = d;

        for (int to : adj[from]) {
            if (!visit[to]) {
                parent[to] = from;
                dfs(to, d + 1);
            }
        }
    }

    private static int lca(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else
                b = parent[b];
        }

        if (a == b) return a;

        while (parent[a] != parent[b]) {
            a = parent[a];
            b = parent[b];
        }

        return parent[a];
    }
}
