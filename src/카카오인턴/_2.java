package 카카오인턴;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _2 {
    static ArrayList<Point> people;
    static boolean[] used;
    static int[] picked;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int row, col;
    static int[] answer;

    public static int[] solution(String[][] places) {
        int len = places.length;
        answer = new int[len];
        Arrays.fill(answer, 1);

        for (int k = 0; k < len; k++) {
            row = places[k].length;
            col = places.length;
            map = new char[row][col];
            people = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = places[k][i].charAt(j);
                    if (map[i][j] == 'P') people.add(new Point(i, j));
                }
            }

            used = new boolean[people.size()];
            picked = new int[2];

            comb(0, 0, k);
        }

        return answer;
    }

    static void comb(int idx, int cnt, int tc) {
        if (cnt == 2) {
            int dist = reach();

            if (dist <= 2) {
                answer[tc] = 0;
            }

            return;
        }

        if (answer[tc] == 0) return;
        if (idx == people.size()) return;

        for (int i = idx; i < people.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                picked[cnt] = i;

                comb(i + 1, cnt + 1, tc);

                used[i] = false;
            }
        }
    }

    static int reach() {
        Point start = people.get(picked[0]);
        Point dest = people.get(picked[1]);
        boolean[][] visit = new boolean[map.length][map[0].length];
        visit[start.x][start.y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Point now = q.poll();

                if (now.x == dest.x && now.y == dest.y) {
                    return dist;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d], ny = now.y + dy[d];

                    if (nx < 0 || nx > row - 1 || ny < 0 || ny > col - 1 || visit[nx][ny] || map[nx][ny] == 'X')
                        continue;

                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }

            dist++;
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"
        }, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
}
