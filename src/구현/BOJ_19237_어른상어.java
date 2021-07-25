package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19237_어른상어 {
    static int N, M, k;
    static int[][] sharkMap;
    static Smell[][] smellMap;
    static Shark[] sharks;
    static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};
    static int remainedSharksCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sharkMap = new int[N][N];
        smellMap = new Smell[N][N];
        sharks = new Shark[M + 1];
        remainedSharksCnt = M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                sharkMap[i][j] = Integer.parseInt(st.nextToken());

                if (sharkMap[i][j] != 0) {
                    sharks[sharkMap[i][j]] = new Shark(sharkMap[i][j], i, j);
                    smellMap[i][j] = new Smell(sharkMap[i][j], i, j, k);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int sharkIdx = 1; sharkIdx <= M; sharkIdx++) {
            sharks[sharkIdx].d = Integer.parseInt(st.nextToken());
        }

        for (int sharkIdx = 1; sharkIdx <= M; sharkIdx++) {
            for (int dir = 1; dir <= 4; dir++) {
                sharks[sharkIdx].priority[dir] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        start();
    }

    static void start() {
        int time = 0;

        while (true) {
            time++;
            findNextPos();
            test(time);

            if (time >= 1000) {
                System.out.println(-1);
                break;
            }
        }
    }

    static void findNextPos() {
        Queue<Shark> moveCandidates = new LinkedList<>();

        for (Shark shark : sharks) {
            if (shark == null) continue;

            int idx = shark.idx, x = shark.x, y = shark.y, d = shark.d;
            int px = 0, py = 0, pd = 0;

            boolean empty = false;
            boolean sameSmell = false;

            for (int dd = 0; dd < 4; dd++) {
                int nd = shark.priority[d][dd];
                int nx = x + dx[nd], ny = y + dy[nd];

                if (!isInRange(nx, ny)) continue;

                if (smellMap[nx][ny] == null) {
                    moveCandidates.add(new Shark(idx, x, y, nx, ny, nd));
                    empty = true;
                    break;
                } else if (!sameSmell && smellMap[nx][ny].sharkIdx == idx) {
                    px = nx;
                    py = ny;
                    pd = nd;
                    sameSmell = true;
                }
            }

            if (!empty) {
                moveCandidates.add(new Shark(idx, x, y, px, py, pd));
            }
        }

        decreaseSmell();

        while (!moveCandidates.isEmpty()) {
            Shark shark = moveCandidates.poll();
            moveShark(shark);
        }
    }

    static void moveShark(Shark shark) {
        int idx = shark.idx, x = shark.x, y = shark.y, nx = shark.nx, ny = shark.ny, nd = shark.nd;
        sharkMap[x][y] = 0;

        if (sharkMap[nx][ny] > 0) {
            int alive = Math.min(sharkMap[nx][ny], idx);
            int dead = Math.max(sharkMap[nx][ny], idx);

            remainedSharksCnt--;

            sharkMap[nx][ny] = alive;

            sharks[dead] = null;

            if (alive == idx) {
                sharks[alive].x = nx;
                sharks[alive].y = ny;
                sharks[alive].d = nd;
            }

            smellMap[nx][ny] = new Smell(alive, nx, ny, k);
        } else {
            sharkMap[nx][ny] = idx;

            sharks[idx].x = nx;
            sharks[idx].y = ny;
            sharks[idx].d = nd;

            smellMap[nx][ny] = new Smell(idx, nx, ny, k);
        }
    }

    static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellMap[i][j] == null) continue;

                if (--smellMap[i][j].smellCnt == 0) {
                    smellMap[i][j] = null;
                }
            }
        }
    }

    static void test(int time) {
        if (remainedSharksCnt == 1 && sharks[1] != null) {
            System.out.println(time);
            System.exit(0);
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Smell {
        int sharkIdx, x, y, smellCnt;

        public Smell(int sharkIdx, int x, int y, int smellCnt) {
            this.sharkIdx = sharkIdx;
            this.x = x;
            this.y = y;
            this.smellCnt = smellCnt;
        }
    }

    static class Shark {
        int idx;
        int x, y, d;
        int nx, ny, nd;
        int[][] priority = new int[5][4];

        public Shark(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public Shark(int idx, int x, int y, int nx, int ny, int nd) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.nx = nx;
            this.ny = ny;
            this.nd = nd;
        }
    }
}
