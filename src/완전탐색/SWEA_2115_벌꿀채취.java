package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {
    static int N, M, C;
    static int[][] map;
    static int[][] memo;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            ans = 0;

            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            map = new int[N][N];
            memo = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(memo[i], -1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    for (int r = i; r < N; r++) {
                        for (int c = r == i ? j + M : 0; c <= N - M; c++) {
                            int first = memo[i][j] == -1 ? memo[i][j] = getMaxProfit(i, j) : memo[i][j];
                            int second = memo[r][c] == -1 ? memo[r][c] = getMaxProfit(r, c) : memo[r][c];
                            ans = Math.max(ans, first + second);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static int getMaxProfit(int x, int y) {
        int[] v = new int[M];
        int total = 0;
        int result = 0;

        for (int i = 0; i < M; i++) {
            v[i] = map[x][y + i];
            total += v[i];
        }

        if (total <= C) {
            for (int i = 0; i < M; i++) {
                result += v[i] * v[i];
            }
            return result;
        } else {
            result = subsum(x, y, 0, 0, 0);
            return result;
        }
    }

    private static int subsum(int x, int y, int idx, int sum, int profit) {
        if (idx == M)
            return profit;

        int val = map[x][y + idx];
        int selected = sum + val <= C ? subsum(x, y, idx + 1, sum + val, profit + val * val) : 0;
        int unselected = subsum(x, y, idx + 1, sum, profit);

        return Math.max(selected, unselected);
    }
}
