package 구현;

import java.util.Scanner;

public class BOJ_2931_가스관 {
    static int R, C;
    static char[][] map;
    static boolean[][][] visit;
    static int mi, mj, zi, zj;

    static String up = "|+14";
    static String down = "|+23";
    static String left = "-+12";
    static String right = "-+34";

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    static int pipe_i, pipe_j;
    static char pipe;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String s = sc.next();
            for (int j = 1; j <= C; j++) {
                char ch = s.charAt(j - 1);

                if (ch == 'M') {
                    mi = i;
                    mj = j;
                } else if (ch == 'Z') {
                    zi = i;
                    zj = j;
                }

                map[i][j] = ch;
            }
        }

        visit = new boolean[R + 1][C + 1][4];

        int dir = setDirection(mi, mj);

        System.out.println("initial dir : " + dir);

        dfs(mi, mj, dir, false);

        System.out.println(pipe_i + " " + pipe_j + " " + pipe);
    }

    private static void dfs(int i, int j, int dir, boolean used) {
        System.out.println("dfs called.");
        System.out.println("i : " + i + ", j : " + j + ", used : " + used);

        visit[i][j][dir] = true;

        if (i == zi && j == zj) {
            return;
        }

        int ndir = setDirection(i, j);
        System.out.println("ndir : " + ndir);

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (!check(ni, nj)) continue;

            if (ndir == -1) {
                if (used)
                    return;
                setPipe(ni, nj, d);
            } else {
                if (visit[ni][nj][ndir] || map[ni][nj] == '.') continue;
                dfs(ni, nj, ndir, used);
            }
        }
    }

    private static int setDirection(int i, int j) {
        if (i - 1 >= 1 && up.contains(String.valueOf(map[i - 1][j]))) {
            return UP;
        } else if (i + 1 <= R && down.contains(String.valueOf(map[i + 1][j]))) {
            return DOWN;
        } else if (j - 1 >= 1 && left.contains(String.valueOf(map[i][j - 1]))) {
            return LEFT;
        } else if (j + 1 <= C && right.contains(String.valueOf(map[i][j + 1]))) {
            return RIGHT;
        } else return -1;
    }

    private static void setPipe(int i, int j, int dir) {
        System.out.println("setPipe called.");
        System.out.println("i : " + i + ", j : " + j + ", dir : " + dir);
        switch (dir) {
            case UP:
                for (int l = 0; l < up.length(); l++) {
                    map[i][j] = up.charAt(l);
                    pipe_i = i;
                    pipe_j = j;
                    pipe = up.charAt(l);
                    if (visit[i][j][UP]) continue;
                    dfs(i, j, UP, true);
                    map[i][j] = '.';
                    pipe_i = -1;
                    pipe_j = -1;
                    pipe = '\0';
                }
                break;
            case DOWN:
                for (int l = 0; l < down.length(); l++) {
                    map[i][j] = down.charAt(l);
                    pipe_i = i;
                    pipe_j = j;
                    pipe = up.charAt(l);
                    if (visit[i][j][DOWN]) continue;
                    dfs(i, j, DOWN, true);
                    map[i][j] = '.';
                    pipe_i = -1;
                    pipe_j = -1;
                    pipe = '\0';
                }
                break;
            case LEFT:
                for (int l = 0; l < left.length(); l++) {
                    map[i][j] = left.charAt(l);
                    pipe_i = i;
                    pipe_j = j;
                    pipe = up.charAt(l);
                    if (visit[i][j][LEFT]) continue;
                    dfs(i, j, LEFT, true);
                    map[i][j] = '.';
                    pipe_i = -1;
                    pipe_j = -1;
                    pipe = '\0';
                }
                break;
            case RIGHT:
                for (int l = 0; l < right.length(); l++) {
                    map[i][j] = right.charAt(l);
                    pipe_i = i;
                    pipe_j = j;
                    pipe = up.charAt(l);
                    if (visit[i][j][RIGHT]) continue;
                    dfs(i, j, RIGHT, true);
                    map[i][j] = '.';
                    pipe_i = -1;
                    pipe_j = -1;
                    pipe = '\0';
                }
                break;
        }
    }

    private static boolean check(int i, int j) {
        if (i < 1 || i > R || j < 1 || j > C) return false;
        return true;
    }
}
