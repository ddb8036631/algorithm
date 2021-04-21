package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[][] wind = {
            {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
            {0, -1, 0, 1, -2, -1, 0, 1, 0, -1},
            {2, 10, 7, 1, 5, 10, 7, 1, 2}
    };
    static final int ALPHA = 9;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2, y = N / 2;
        int dir = 0;
        int maxCnt = 1;
        int cnt = 0;

        while (true) {
            int nx = x + dx[dir], ny = y + dy[dir];
            cnt++;

            scatter(nx, ny, dir);

            if (x == 0 && y == 1) break;

            map[nx][ny] = 0;
            x = nx;
            y = ny;

            if (cnt == maxCnt) {
                dir = (dir + 1) % 4;
                cnt = 0;

                if (dir == 0 || dir == 2) maxCnt++;
            }
        }

        System.out.println(answer);
    }

    static void scatter(int x, int y, int dir) {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int[] rotated = new int[]{wind[0][i], wind[1][i]};

            for (int d = 0; d < dir; d++) rotated = rotate(rotated);

            int tx = x + rotated[0];
            int ty = y + rotated[1];

            if (i == ALPHA) {
                if (!inRange(tx, ty)) answer += map[x][y] - sum;
                else map[tx][ty] += map[x][y] - sum;

                continue;
            }

            int scatterd = map[x][y] * wind[2][i] / 100;

            if (scatterd == 0) continue;
            else if (!inRange(tx, ty)) answer += scatterd;
            else map[tx][ty] += scatterd;

            sum += scatterd;
        }
    }

    static int[] rotate(int[] arr) {
        return new int[]{arr[1] == 0 ? 0 : -arr[1], arr[0]};
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
