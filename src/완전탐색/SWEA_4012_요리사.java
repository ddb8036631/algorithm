package 완전탐색;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_4012_요리사 {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            ans = Integer.MAX_VALUE;

            N = sc.nextInt();
            map = new int[N][N];
            visit = new boolean[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            dfs(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void calc() {
        ArrayList<Integer> list_A = new ArrayList<>();
        ArrayList<Integer> list_B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (visit[i])
                list_A.add(i);
            else
                list_B.add(i);
        }

        int sum_A = 0;
        int sum_B = 0;

        for (int i = 0; i < list_A.size(); i++) {
            for (int j = 0; j < list_A.size(); j++) {
                sum_A += map[list_A.get(i)][list_A.get(j)];
                sum_B += map[list_B.get(i)][list_B.get(j)];
            }
        }

        ans = Math.min(ans, Math.abs(sum_A - sum_B));
    }
}
