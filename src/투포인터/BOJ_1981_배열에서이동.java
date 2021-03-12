package 투포인터;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1981_배열에서이동 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        int answer = 200, start = 0, end = 0;

        while (start <= 200 && end <= 200) {
            if (bfs(start, end)) {
                answer = Math.min(answer, end - start);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs(int start, int end) {
        if (map[0][0] < start || map[0][0] > end) return false;

        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[N][N];

        visit[0][0] = true;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == N - 1) return true;

            for (int d = 0; d < 4; d++) {
                int ni = now[0] + di[d];
                int nj = now[1] + dj[d];

                if (inRange(ni, nj) && !visit[ni][nj] && start <= map[ni][nj] && map[ni][nj] <= end) {
                    visit[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }

        return false;
    }

    private static boolean inRange(int i, int j) {
        if (i < 0 || i > N - 1 || j < 0 || j > N - 1) return false;
        return true;
    }
}
