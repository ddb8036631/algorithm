package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                System.out.println(i);
                System.exit(0);
            }

            union(pa, pb);
        }

        System.out.println(0);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
