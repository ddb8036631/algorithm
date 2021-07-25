package 너비우선탐색;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        boolean[][] visit = new boolean[R][C];
        int sheepCnt = 0, wolfCnt = 0;
        Queue<Point> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && map[i][j] != '#') {
                    visit[i][j] = true;
                    q.add(new Point(i, j));
                    int sc = 0, wc = 0;

                    while (!q.isEmpty()) {
                        Point now = q.poll();

                        if (map[now.x][now.y] == 'k') sc++;
                        else if (map[now.x][now.y] == 'v') wc++;

                        for (int d = 0; d < 4; d++) {
                            int nx = now.x + dx[d], ny = now.y + dy[d];

                            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#' || visit[nx][ny]) continue;

                            visit[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }

                    if (sc > wc) sheepCnt += sc;
                    else wolfCnt += wc;
                }
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }
}
