package SWEA_모의SW역량테스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_4013_특이한자석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int K = sc.nextInt();
            int[][] magnet = new int[4][8];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = sc.nextInt();
                }
            }

            for (int k = 0; k < K; k++) {
                int idx = sc.nextInt() - 1;
                int dir = sc.nextInt();

                int tmpIdx = idx;
                int tmpDir = dir;

                List<Pair> rebuildList = new ArrayList<>();
                rebuildList.add(new Pair(idx, dir));

                // 왼쪽
                while (tmpIdx > 0) {
                    if (magnet[tmpIdx][6] == magnet[tmpIdx - 1][2]) {
                        break;
                    }

                    tmpDir = tmpDir == 1 ? 0 : 1;
                    rebuildList.add(new Pair(tmpIdx - 1, tmpDir));

                    tmpIdx--;
                }

                tmpIdx = idx;
                tmpDir = dir;

                // 오른쪽
                while (tmpIdx < 3) {
                    if (magnet[tmpIdx][2] == magnet[tmpIdx + 1][6]) {
                        break;
                    }

                    tmpDir = tmpDir == 1 ? 0 : 1;
                    rebuildList.add(new Pair(tmpIdx + 1, tmpDir));

                    tmpIdx++;
                }

                rebuild(magnet, rebuildList);
            }

            int ans = 0;
            ans += magnet[0][0] == 1 ? 1 : 0;
            ans += magnet[1][0] == 1 ? 2 : 0;
            ans += magnet[2][0] == 1 ? 4 : 0;
            ans += magnet[3][0] == 1 ? 8 : 0;

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void rebuild(int[][] magnet, List<Pair> rebuildList) {
        for (Pair p : rebuildList) {
            int idx = p.idx;
            int dir = p.dir;

            // 시계 방향
            if (dir == 1) {
                int tmp = magnet[idx][7];
                for (int i = 6; i >= 0; i--) {
                    magnet[idx][i + 1] = magnet[idx][i];
                }
                magnet[idx][0] = tmp;
            }

            // 반시계 방향
            else {
                int tmp = magnet[idx][0];
                for (int i = 1; i <= 7; i++) {
                    magnet[idx][i - 1] = magnet[idx][i];
                }
                magnet[idx][7] = tmp;
            }
        }
    }

    public static class Pair {
        int idx;
        int dir;

        public Pair(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
}
