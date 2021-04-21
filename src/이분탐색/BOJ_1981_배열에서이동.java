package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1981_배열에서이동 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int low = 0;
        int high = 200;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bfs(mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs(int mid) {
        for (boolean[] v : visit) Arrays.fill(v, false);

        Queue<Point> q = new LinkedList<>();
        visit[0][0] = true;
        q.add(new Point(0, 0, map[0][0], map[0][0]));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N - 1 && now.y == N - 1 && now.max - now.min <= mid) return true;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d], ny = now.y + dy[d];

                if (!isRange(nx, ny) || visit[nx][ny]) continue;

                if (Math.abs(map[nx][ny] - now.min) <= mid) {
                    int min = Math.min(now.min, map[nx][ny]);
                    int max = Math.max(now.max, map[nx][ny]);
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny, min, max));
                }
            }
        }

        return false;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Point {
        int x, y, min, max;

        public Point(int x, int y, int min, int max) {
            this.x = x;
            this.y = y;
            this.min = min;
            this.max = max;
        }
    }
}
