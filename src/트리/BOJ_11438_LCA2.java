package 트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11438_LCA2 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] depth;
    static int[][] ancestor;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        visit = new boolean[N + 1];
        depth = new int[N + 1];
        ancestor = new int[N + 1][18];

        for (int i = 0; i < N - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        dfs(1, 1, 0);
        setAncestor();

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            sb.append(lca(sc.nextInt(), sc.nextInt()) + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int parent, int now, int d) {
        visit[now] = true;
        depth[now] = d;
        ancestor[now][0] = parent;

        for (int next : adj[now]) {
            if (!visit[next]) {
                dfs(now, next, d + 1);
            }
        }
    }

    private static void setAncestor() {
        for (int j = 1; j <= 17; j++) {
            for (int i = 1; i <= N; i++) {
                ancestor[i][j] = ancestor[ancestor[i][j - 1]][j - 1];
            }
        }
    }

    private static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (depth[a] != depth[b]) {
            int diff = depth[b] - depth[a];

            for (int i = 0; i <= 17; i++) {
                if ((diff & (1 << i)) != 0) {
                    b = ancestor[b][i];
                }
            }
        }

        if (a == b) return a;

        for (int i = 17; i >= 0; i--) {
            if (ancestor[a][i] != ancestor[b][i]) {
                a = ancestor[a][i];
                b = ancestor[b][i];
            }
        }

        return ancestor[a][0];
    }
}
