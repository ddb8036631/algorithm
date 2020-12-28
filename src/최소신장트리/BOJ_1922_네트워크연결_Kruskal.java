package 최소신장트리;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1922_네트워크연결_Kruskal {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++)
            makeSet(i);

        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int a = find(edges[i][0]);
            int b = find(edges[i][1]);

            if (a == b) continue;

            union(a, b);
            cnt++;
            answer += edges[i][2];

            if (cnt == N - 1) break;
        }

        System.out.println(answer);
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int find(int idx) {
        if (idx == parent[idx]) return idx;
        else return parent[idx] = find(parent[idx]);
    }

    static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (rank[ap] > rank[bp]) {
            parent[bp] = ap;
        } else {
            parent[ap] = bp;

            if (rank[ap] == rank[bp])
                rank[ap]++;
        }
    }
}
