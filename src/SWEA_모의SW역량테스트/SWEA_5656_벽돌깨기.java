package SWEA_모의SW역량테스트;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
    static int N, W, H;
    static int[][] map;
    static int[][][] copy_map;
    static int[] selected;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            ans = Integer.MAX_VALUE;

            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();

            map = new int[H][W];
            copy_map = new int[N + 1][H][W];
            selected = new int[N];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                    copy_map[0][i][j] = map[i][j];
                }
            }

            perm(0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void perm(int idx) {
        if (idx == N) {
            int cnt = 0;

            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    if (copy_map[N][i][j] != 0)
                        cnt++;

            ans = Math.min(ans, cnt);

            return;
        }

        for (int i = 0; i < W; i++) {
            selected[idx] = i;
            rebuild(idx + 1);
            perm(idx + 1);
        }
    }

    private static void rebuild(int idx) {
        for (int i = 0; i < H; i++) {
            copy_map[idx][i] = copy_map[idx - 1][i].clone();
        }

        int h = 0;
        int w = selected[idx - 1];

        while (h < H && copy_map[idx][h][w] == 0)
            h++;

        if (h == H) return;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[H][W];

        visit[h][w] = true;
        queue.add(new int[]{h, w, copy_map[idx][h][w]});
        copy_map[idx][h][w] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                for (int n = 1; n < cur[2]; n++) {
                    int ni = cur[0] + di[d] * n;
                    int nj = cur[1] + dj[d] * n;

                    if (ni < 0 || ni > H - 1 || nj < 0 || nj > W - 1 || visit[ni][nj] || copy_map[idx][ni][nj] == 0)
                        continue;

                    visit[ni][nj] = true;
                    queue.add(new int[]{ni, nj, copy_map[idx][ni][nj]});
                    copy_map[idx][ni][nj] = 0;
                }
            }
        }

        for (int j = 0; j < W; j++) {
            for (int i = H - 1; i >= 0; i--) {
                if (copy_map[idx][i][j] != 0) continue;

                int target = i;
                while (target >= 0 && copy_map[idx][target][j] == 0)
                    target--;

                if (target >= 0) {
                    copy_map[idx][i][j] = copy_map[idx][target][j];
                    copy_map[idx][target][j] = 0;
                }
            }
        }
    }
}
