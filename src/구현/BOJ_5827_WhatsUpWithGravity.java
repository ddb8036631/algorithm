package 구현;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_5827_WhatsUpWithGravity {
    static int N, M;
    static char[][] map;
    static int[][] counts;

    // ↓ ↑ ← → 하 상 좌 우 순서
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int start_x, start_y, end_x, end_y;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N + 1][M + 1];
        counts = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for(int j=1; j<=M; j++) {
                counts[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= N; i++) {
            String s = sc.next();
            for (int j = 1; j <= M; j++) {
                char ch = s.charAt(j - 1);

                if (ch == 'C') {
                    start_x = i;
                    start_y = j;
                    ch = '.';
                } else if (ch == 'D') {
                    end_x = i;
                    end_y = j;
                    ch = '.';
                }

                map[i][j] = ch;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.cnt - o2.cnt;
            }
        });

        pq.add(new Point(start_x, start_y, 0, 0));
        counts[start_x][start_y] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            System.out.println("now.x : " + now.x + ", now.y : " + now.y + ", now.gravity : " + now.gravity + ", now.cnt : " + now.cnt);

            if (now.x == end_x && now.y == end_y) {
                answer = now.cnt;
                break;
            }

            // 규칙1 & 2: 밑에가 비어있으면 쭉 내려봄.
            // null이면, 규칙 1에 의해 이 좌표로는 더이상 진행이 불가능.
            // null이 아니면, 규칙 3을 이 좌표부터 수행.
            int[] bottom = down(now.x, now.y, now.gravity);
            if (bottom == null) continue;

            for (int d = 2; d < 4; d++) {
                int next_x = now.x + dx[d];
                int next_y = now.y + dy[d];

                if (!check(next_x, next_y) || map[next_x][next_y] == '#') continue;

                bottom = down(next_x, next_y, now.gravity);
                if (bottom == null) continue;

                if (now.cnt < counts[bottom[0]][bottom[1]]) {
                    counts[bottom[0]][bottom[1]] = now.cnt;
                    pq.add(new Point(bottom[0], bottom[1], now.gravity, now.cnt));
                }
            }

            bottom = down(now.x, now.y, now.gravity == 0 ? 1 : 0);
            pq.add(new Point(now.x, now.y, now.gravity == 0 ? 1 : 0, now.cnt + 1));
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int[] down(int x, int y, int gravity) {
        int underneath_x, underneath_y;

        // 밑으로 최대한 이동하기.
        while (true) {
            underneath_x = x + dx[gravity];
            underneath_y = y + dy[gravity];

            if (!check(underneath_x, underneath_y)) return null; // 격자 밖으로 나가면, null을 리턴 실패를 의미.

            if (map[underneath_x][underneath_y] == '.') { // 아래가 빈 셀이면 계속 내려봄.
                if (underneath_x == end_x && underneath_y == end_y) {
                    return new int[]{underneath_x, underneath_y};
                }

                x = underneath_x;
                y = underneath_y;
            } else if (map[underneath_x][underneath_y] == '#') break; // 아래가 막혀있는 셀이면 그만함.
        }

        return new int[]{x, y};
    }

    private static boolean check(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > M) return false;
        return true;
    }

    private static class Point {
        int x, y, gravity, cnt;

        public Point(int x, int y, int gravity, int cnt) {
            this.x = x;
            this.y = y;
            this.gravity = gravity;
            this.cnt = cnt;
        }
    }
}

// 1 : 정답
// 2 : 정답
// 3 : 정답
// 4 : 정답
// 5 : 런타임 에러
// 6 : 런타임 에러
// 7 : 런타임 에러
// 8 : 오답(답 13, 내 답 785)
// 9 : 정답
// 10 : 정답