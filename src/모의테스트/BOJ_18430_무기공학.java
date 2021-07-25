package 모의테스트;

import java.util.Scanner;

public class BOJ_18430_무기공학 {
    static int N, M;
    static int[][] map;
    static boolean[][] used;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        used = new boolean[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        dfs(0, 0, 0);

        System.out.println(max);
    }

    static void dfs(int x, int y, int sum) {
        if (y == M) {
            y = 0;
            x++;
        }

        if (x == N) {
            max = Math.max(max, sum);
            return;
        }

        if (isInRange(x, y - 1) && isInRange(x + 1, y) && !used[x][y] && !used[x][y - 1] && !used[x + 1][y]) {
            used[x][y] = used[x][y - 1] = used[x + 1][y] = true;
            dfs(x, y + 1, sum + 2 * map[x][y] + map[x][y - 1] + map[x + 1][y]);
            used[x][y] = used[x][y - 1] = used[x + 1][y] = false;
        }

        if (isInRange(x, y - 1) && isInRange(x - 1, y) && !used[x][y] && !used[x][y - 1] && !used[x - 1][y]) {
            used[x][y] = used[x][y - 1] = used[x - 1][y] = true;
            dfs(x, y + 1, sum + 2 * map[x][y] + map[x][y - 1] + map[x - 1][y]);
            used[x][y] = used[x][y - 1] = used[x - 1][y] = false;
        }

        if (isInRange(x - 1, y) && isInRange(x, y + 1) && !used[x][y] && !used[x - 1][y] && !used[x][y + 1]) {
            used[x][y] = used[x - 1][y] = used[x][y + 1] = true;
            dfs(x, y + 1, sum + 2 * map[x][y] + map[x - 1][y] + map[x][y + 1]);
            used[x][y] = used[x - 1][y] = used[x][y + 1] = false;
        }

        if (isInRange(x + 1, y) && isInRange(x, y + 1) && !used[x][y] && !used[x + 1][y] && !used[x][y + 1]) {
            used[x][y] = used[x + 1][y] = used[x][y + 1] = true;
            dfs(x, y + 1, sum + 2 * map[x][y] + map[x + 1][y] + map[x][y + 1]);
            used[x][y] = used[x + 1][y] = used[x][y + 1] = false;
        }

        dfs(x, y + 1, sum);
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
