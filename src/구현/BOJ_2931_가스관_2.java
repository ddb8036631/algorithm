package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2931_가스관_2 {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int mi, mj, zi, zj;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static String up = "|+14";
    static String down = "|+23";
    static String left = "-+12";
    static String right = "-+34";
    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    static int target_i, target_j;
    static char prevPipe;
    static List<Integer> candidates;
    static char answer;
    static boolean exit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R + 1][C + 1];
        visit = new boolean[R + 1][C + 1];
        candidates = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            String s = sc.next();
            for (int j = 1; j <= C; j++) {
                char ch = s.charAt(j - 1);

                if (ch == 'M') {
                    mi = i;
                    mj = j;
                    map[i][j] = '+';
                } else if (ch == 'Z') {
                    zi = i;
                    zj = j;
                    map[i][j] = '+';
                } else {
                    map[i][j] = ch;
                }
            }
        }

        boolean noAdjacentPipe = true;
        for (int d = 0; d < 4; d++) {
            int ni = mi + di[d];
            int nj = mj + dj[d];
            if (canGo(ni, nj)) {
                noAdjacentPipe = false;
                dfs(ni, nj, d);
            }
        }

        if (noAdjacentPipe) {
            for (int d = 0; d < 4; d++) {
                int ni = mi + di[d];
                int nj = mj + dj[d];

                if (inRange(ni, nj)) {
                    setTarget(ni, nj, '+');
                    candidates.clear();
                    makeCandidates();
                    choosePipe();
                }
            }
        } else {
            makeCandidates();
            choosePipe();
        }
    }

    static void dfs(int i, int j, int dir) {
        visit[i][j] = true;

//        System.out.println("i : " + i + ", j : " + j);

        if (i == zi && j == zj) {
            System.out.println(target_i + " " + target_j + " " + answer);
            System.exit(0);
        }

        dir = setDirection(i, j, dir);

        int ni = i + di[dir];
        int nj = j + dj[dir];

        if (inRange(ni, nj)) {
            switch (dir) {
                case UP:
                    if (!visit[ni][nj] && up.contains(String.valueOf(map[ni][nj])) || (visit[ni][nj] && map[ni][nj] == '+')) dfs(ni, nj, UP);
                    else setTarget(ni, nj, map[i][j]);
                    break;
                case DOWN:
                    if (!visit[ni][nj] && down.contains(String.valueOf(map[ni][nj])) || (visit[ni][nj] && map[ni][nj] == '+')) dfs(ni, nj, DOWN);
                    else setTarget(ni, nj, map[i][j]);
                    break;
                case LEFT:
                    if (!visit[ni][nj] && left.contains(String.valueOf(map[ni][nj])) || (visit[ni][nj] && map[ni][nj] == '+')) dfs(ni, nj, LEFT);
                    else setTarget(ni, nj, map[i][j]);
                    break;
                case RIGHT:
                    if (!visit[ni][nj] && right.contains(String.valueOf(map[ni][nj])) || (visit[ni][nj] && map[ni][nj] == '+')) dfs(ni, nj, RIGHT);
                    else setTarget(ni, nj, map[i][j]);
                    break;
            }
        }

        visit[i][j] = false;
    }

    static boolean inRange(int i, int j) {
        if (i < 1 || i > R || j < 1 || j > C) return false;
        return true;
    }

    static boolean canGo(int i, int j) {
        if (inRange(i, j) && map[i][j] != '.' && map[i][j] != 'M' && map[i][j] != 'Z') return true;
        return false;
    }

    static int setDirection(int i, int j, int dir) {
        if (map[i][j] == '1') {
            if (dir == UP) return RIGHT;
            else return DOWN;
        } else if (map[i][j] == '2') {
            if (dir == DOWN) return RIGHT;
            else return UP;
        } else if (map[i][j] == '3') {
            if (dir == DOWN) return LEFT;
            else return UP;
        } else if (map[i][j] == '4') {
            if (dir == UP) return LEFT;
            else return DOWN;
        } else return dir;
    }

    static void setTarget(int i, int j, char shape) {
        target_i = i;
        target_j = j;
        prevPipe = shape;
    }

    static void makeCandidates() {
        for (int d = 0; d < 4; d++) {
            int ni = target_i + di[d];
            int nj = target_j + dj[d];

            if (!inRange(ni, nj)) continue;

            if (d == UP && up.contains(String.valueOf(map[ni][nj]))) candidates.add(UP);
            else if (d == DOWN && down.contains(String.valueOf(map[ni][nj]))) candidates.add(DOWN);
            else if (d == LEFT && left.contains(String.valueOf(map[ni][nj]))) candidates.add(LEFT);
            else if (d == RIGHT && right.contains(String.valueOf(map[ni][nj]))) candidates.add(RIGHT);
        }
    }

    static void choosePipe() {
        if (candidates.size() == 4) answer = '+';
        else if (candidates.contains(LEFT) && candidates.contains(RIGHT)) answer = '-';
        else if (candidates.contains(DOWN) && candidates.contains(RIGHT)) answer = '1';
        else if (candidates.contains(UP) && candidates.contains(RIGHT)) answer = '2';
        else if (candidates.contains(UP) && candidates.contains(LEFT)) answer = '3';
        else if (candidates.contains(DOWN) && candidates.contains(LEFT)) answer = '4';
        else if (candidates.contains(UP) && candidates.contains(DOWN)) answer = '|';

        map[target_i][target_j] = answer;

//        for(int i=1;i<=R;i++) {
//            for(int j=1;j<=C;j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int d = 0; d < 4; d++) {
            int ni = mi + di[d];
            int nj = mj + dj[d];
            if (canGo(ni, nj)) dfs(ni, nj, d);
        }
        map[target_i][target_j] = '.';
    }
}
