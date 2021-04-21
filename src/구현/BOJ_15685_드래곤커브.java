package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static int N;
    static boolean[][] map;
    static final int SIZE = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[SIZE][SIZE];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(y, x, d, g);
        }

        int answer = 0;

        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) answer++;
            }
        }

        System.out.println(answer);
    }

    static void draw(int sx, int sy, int sd, int tg) {
        Point[] endPoints = new Point[(int) Math.pow(2, tg)];
        int nx = sx + dx[sd], ny = sy + dy[sd];
        endPoints[0] = new Point(nx, ny, sd);
        int gen = 1;

        while (true) {
            if (gen == tg + 1) break;

            int genStartIdx = (int) Math.pow(2, gen - 1);

            for (int i = genStartIdx; i < genStartIdx + Math.pow(2, gen - 1); i++) {
                Point prev = endPoints[(int) Math.pow(2, gen) - i - 1];
                int nd = (prev.d + 1) % 4;
                nx += dx[nd];
                ny += dy[nd];
                endPoints[i] = new Point(nx, ny, nd);
            }

            gen++;
        }

        map[sx][sy] = true;

        for (Point endPoint : endPoints) {
            map[endPoint.x][endPoint.y] = true;
        }
    }

    static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
