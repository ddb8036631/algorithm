package 모의테스트;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17143_낚시왕 {
    static int R, C, M;
    static Shark[][] map;
    static Shark[] sharks;
    static HashMap<Point, Shark> movedSharks;
    static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];
        sharks = new Shark[M + 1];
        movedSharks = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r, c, s, d, z;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            s = (d == 1 || d == 2) ? s % (2 * (R - 1)) : s % (2 * (C - 1));

            map[r][c] = new Shark(i, r, c, s, d, z);
            sharks[i] = new Shark(i, r, c, s, d, z);
        }

        for (int j = 1; j <= C; j++) {
            fishing(j);
            move();
        }

        System.out.println(answer);
    }

    static void fishing(int now) {
        Shark target = null;

        for (int i = 1; i <= R; i++) {
            if (map[i][now] == null) continue;

            target = map[i][now];
            break;
        }

        if (target == null) return;

        answer += target.z;

        sharks[target.idx] = null;
        map[target.x][target.y] = null;
    }

    static void move() {
        movedSharks.clear();

        for (int i = 1; i <= M; i++) {
            Shark target = sharks[i];

            if (target == null) continue;

            int[] movedPosDir = getMovedPosDir(target);
            Shark movedShark = new Shark(target.idx, movedPosDir[0], movedPosDir[1], target.s, movedPosDir[2], target.z);
            Point key = new Point(movedPosDir[0], movedPosDir[1]);

            if (movedSharks.containsKey(key)) {
                Shark origin = movedSharks.get(key);

                if (origin.z < movedShark.z) {
                    movedSharks.put(key, movedShark);
                    sharks[origin.idx] = null;
                } else {
                    sharks[movedShark.idx] = null;
                }
            } else {
                movedSharks.put(key, movedShark);
            }

            map[target.x][target.y] = null;
        }

        for (Map.Entry<Point, Shark> entry : movedSharks.entrySet()) {
            Point key = entry.getKey();
            Shark val = entry.getValue();

            map[key.x][key.y] = val;
            sharks[val.idx] = val;
        }
    }

    static int[] getMovedPosDir(Shark shark) {
        int speed = shark.s;
        int x = shark.x, y = shark.y;
        int dir = shark.d;

        while (speed-- > 0) {
            int nx = x + dx[dir], ny = y + dy[dir];

            if (!inRange(nx, ny)) {
                dir = changeDir(dir);
                x = x + dx[dir];
                y = y + dy[dir];
            } else {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y, dir};
    }

    static int changeDir(int dir) {
        if (dir == 1) return 2;
        else if (dir == 2) return 1;
        else if (dir == 3) return 4;
        else return 3;
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= R && y >= 1 && y <= C;
    }

    static class Shark {
        int idx;
        int x, y, s, d, z;

        public Shark(int idx, int x, int y, int s, int d, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
