package 카카오2020;

import java.util.ArrayList;

public class 기둥과보 {
    public static ArrayList<int[]> solution(int n, int[][] build_frame) {
        Point[][] map = new Point[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = new Point(false, false);
            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0], y = build_frame[i][1], a = build_frame[i][2], b = build_frame[i][3];

            // 삭제인 경우.
            if (b == 0) {
                // 입력으로 기둥이 들어오고, 기둥이 존재하며, 동시에 삭제가 가능하면 삭제.
                if (a == 0) {
                    map[y][x].gidung = false;
                    if (!canRemove(n, map))
                        map[y][x].gidung = true;
                }

                // 입력으로 보가 들어오고, 보가 존재하며, 동시에 삭제가 가능하면 삭제.
                else {
                    map[y][x].bo = false;
                    if (!canRemove(n, map))
                        map[y][x].bo = true;
                }
            }

            // 설치인 경우.
            else {
                // 입력으로 기둥이 들어오고, 기둥 설치가 가능하면 설치.
                if (a == 0 && canBuildGidung(y, x, map)) {
                    map[y][x].gidung = true;
                }
                // 입력으로 보가 들어오고, 보 설치가 가능하면 설치.
                else if (a == 1 && canBuildBo(n, y, x, map)) {
                    map[y][x].bo = true;
                }
            }
        }

        ArrayList<int[]> answer = new ArrayList<>();
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= n; i++) {
                if (map[i][j].gidung) answer.add(new int[]{j, i, 0});
                if (map[i][j].bo) answer.add(new int[]{j, i, 1});
            }
        }

        return answer;
    }

    static boolean canBuildGidung(int x, int y, Point[][] map) {
        // 1. 바닥 위에 있는 경우.
        // 2. 한쪽 끝 부분이 보인 경우.
        // 3. 다른 기둥 위에 있는 경우.
        return x == 0 || (y - 1 >= 0 && map[x][y - 1].bo) || map[x][y].bo || (x - 1 >= 0 && map[x - 1][y].gidung);
    }

    static boolean canBuildBo(int n, int x, int y, Point[][] map) {
        // 1. 한쪽 끝 부분이 기둥 위인 경우.
        // 2. 양쪽 끝 부분이 보인 경우.
        return (x - 1 >= 0 && map[x - 1][y].gidung) || (x - 1 >= 0 && y + 1 <= n && map[x - 1][y + 1].gidung) || (y - 1 >= 0 && y + 1 <= n && map[x][y - 1].bo && map[x][y + 1].bo);
    }

    static boolean canRemove(int n, Point[][] map) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (map[i][j].gidung && !canBuildGidung(i, j, map)) return false;
                if (map[i][j].bo && !canBuildBo(n, i, j, map)) return false;
            }
        }

        return true;
    }

    static class Point {
        boolean gidung, bo;

        public Point(boolean gidung, boolean bo) {
            this.gidung = gidung;
            this.bo = bo;
        }
    }

    public static void main(String[] args) {
        solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
//        solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }
}
