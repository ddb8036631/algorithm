package 모의테스트;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11967_불켜기 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        Switch[][] map = new Switch[N][N];
        boolean[][] visit = new boolean[N][N];
        boolean[][] on = new boolean[N][N];
        HashSet<Point> candidates = new HashSet<>();
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        int answer = 1;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = new Switch();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x, y, a, b;
            x = stoi(st.nextToken()) - 1;
            y = stoi(st.nextToken()) - 1;
            a = stoi(st.nextToken()) - 1;
            b = stoi(st.nextToken()) - 1;

            map[x][y].switches.add(new Point(a, b));
        }

        Queue<Point> queue = new LinkedList<>();
        on[0][0] = true;
        visit[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (Point next : map[now.x][now.y].switches) {
                if (!on[next.x][next.y]) {
                    on[next.x][next.y] = true;
                    answer++;

                    if (candidates.contains(next)) {
                        queue.add(next);
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d], ny = now.y + dy[d];

                if (!isInRange(nx, ny) || visit[nx][ny]) continue;
                if (!on[nx][ny]) {
                    candidates.add(new Point(nx, ny));
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        System.out.println(answer);
    }

    static class Switch {
        ArrayList<Point> switches = new ArrayList<>();
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
