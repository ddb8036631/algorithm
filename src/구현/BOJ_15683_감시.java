package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    static int N, M;
    static int[][] map;
    static CCTV[] cctvs = new CCTV[8];
    static int cctvCnt;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] dir = {
            {},
            {1},
            {1, 3},
            {0, 1},
            {0, 1, 3},
            {0, 1, 2, 3}
    };
    static int answer = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 0 || num == 6) continue;

                cctvs[cctvCnt++] = new CCTV(i, j, num);
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int now, int[][] map) {
        if (now == cctvCnt) {
            calcMin(map);

            return;
        }

        int x = cctvs[now].x, y = cctvs[now].y, num = cctvs[now].num;

        for (int d = 0; d < 4; d++) {
            int[][] copied = copy(map);

            for (int i = 0; i < dir[num].length; i++) {
                int nd = (dir[num][i] + d) % 4;
                int nx = x, ny = y;

                while (true) {
                    nx += dx[nd];
                    ny += dy[nd];

                    if (!inRange(nx, ny) || map[nx][ny] == 6) break;

                    copied[nx][ny] = -1;
                }
            }

            dfs(now + 1, copied);
        }
    }

    static void calcMin(int[][] copiedMap) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copiedMap[i][j] == 0) cnt++;
            }
        }

        answer = Math.min(answer, cnt);
    }

    static int[][] copy(int[][] arr) {
        int[][] copied = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                copied[i][j] = arr[i][j];

        return copied;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class CCTV {
        int x, y, num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
