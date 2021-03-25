package 너비우선탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14496_그대그머가되어 {
    static int a, b, N, M;
    static ArrayList<Integer> adj[];
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visit[a] = true;
        q.add(new int[]{a, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == b) {
                return now[1];
            }

            for (int next : adj[now[0]]) {
                if (visit[next]) continue;
                visit[next] = true;
                q.add(new int[]{next, now[1] + 1});
            }
        }

        return -1;
    }
}
