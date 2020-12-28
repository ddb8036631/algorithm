package 최소신장트리;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1251_하나로 {
    static int[] parent;
    static int[] rank;
    static int N;
    static int[] X, Y;
    static double E;
    static Edge[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();

            parent = new int[N];
            rank = new int[N];

            edges = new Edge[N * (N - 1) / 2];

            X = new int[N];
            Y = new int[N];

            for (int i = 0; i < N; i++) {
                X[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                Y[i] = sc.nextInt();
            }

            E = sc.nextDouble();
            int cnt = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (cnt == N * (N - 1) / 2 + 1)
                        break;
                    edges[cnt++] = new Edge(i, j, dist(i, j));
                }
            }

            for (int i = 0; i < N; i++)
                makeSet(i);

            Arrays.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Double.compare(o1.cost, o2.cost);
                }
            });

            cnt = 0;
            double answer = 0;
            for (Edge e : edges) {
                int a = e.start;
                int b = e.dest;

                if (find(a) == find(b)) continue;

                union(a, b);
                answer += e.cost;
                cnt++;
            }

            System.out.println("#" + tc + " " + Math.round(answer));
        }
    }

    static double dist(int i, int j) {
        double d = Math.sqrt(Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
        return E * d * d;
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py])
            parent[py] = px;
        else {
            parent[px] = py;

            if (rank[px] == rank[py])
                rank[px]++;
        }
    }

    static class Edge {
        int start;
        int dest;
        double cost;

        public Edge(int start, int dest, double cost) {
            this.start = start;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", dest=" + dest +
                    ", cost=" + cost +
                    '}';
        }
    }
}
