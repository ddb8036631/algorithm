package 카카오2017_카카오코드예선;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int groupCnt;
    static int groupArea;

    public static int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        groupCnt = 0;
        groupArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    groupCnt++;
                    bfs(i, j, m, n, picture);
                }
            }
        }

        return new int[]{groupCnt, groupArea};
    }

    static void bfs(int x, int y, int m, int n, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d], ny = now[1] + dy[d];

                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1 || visit[nx][ny] || picture[nx][ny] != picture[now[0]][now[1]])
                    continue;

                visit[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        groupArea = Math.max(groupArea, cnt);
    }

    public static void main(String[] args) {
//        solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        solution(3, 3, new int[][]{{0, 1, 0}, {1, 1, 0}, {0, 0, 0}});
    }
}
