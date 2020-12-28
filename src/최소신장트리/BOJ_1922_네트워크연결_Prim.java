package 최소신장트리;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1922_네트워크연결_Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Edge> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Edge(a, b, c));
            list.add(new Edge(b, a, c));
        }

        boolean[] used = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 1, 0));

        int answer = 0;
        while (N-- > 0) {
            Edge now = null;

            while (!pq.isEmpty()) {
                now = pq.poll();

                if (!used[now.v2]) {
                    used[now.v2] = true;
                    answer += now.cost;

                    break;
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (now.v2 == list.get(i).v1 && !used[list.get(i).v2]) {
                    pq.add(list.get(i));
                }
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
