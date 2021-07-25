package 너비우선탐색;

import java.util.*;

public class BOJ_2638_치즈 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static List<int[]> melting = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;

        while (!empty()) {
            time++;
            findExternalAir();
            findMeltingPos();
            melt();
        }

        System.out.println(time);
    }

    static boolean empty() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != -1) return false;
            }
        }

        return true;
    }

    static void findExternalAir() {
        int[][] tmpMap = cloneArr();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N + 1][M + 1];
        visit[0][0] = true;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            tmpMap[x][y] = -1;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (!isRange(nx, ny)) continue;
                if (!(tmpMap[nx][ny] == 0 || tmpMap[nx][ny] == -1)) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        map = tmpMap;
    }

    static void findMeltingPos() {
        boolean[][] visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0], y = now[1];
                        int cnt = 0;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d], ny = y + dy[d];

                            if (!isRange(nx, ny)) continue;

                            if (map[nx][ny] == -1) {
                                cnt++;
                            }

                            if (!visit[nx][ny] && map[nx][ny] == 1) {
                                visit[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }

                            if (cnt >= 2) {
                                melting.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
    }

    static void melt() {
        for (int[] pos : melting) {
            int x = pos[0], y = pos[1];
            map[x][y] = -1;
        }

        melting.clear();
    }

    static int[][] cloneArr() {
        int[][] tmpMap = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        return tmpMap;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x <= N && y >= 0 && y <= M;
    }
}
