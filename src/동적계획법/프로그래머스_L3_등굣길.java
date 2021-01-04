package 동적계획법;

public class 프로그래머스_L3_등굣길 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        final int MOD = 1000000007;

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                if (i - 1 >= 1) {
                    map[i][j] = (map[i][j] + map[i - 1][j]) % MOD;
                }
                if (j - 1 >= 1) {
                    map[i][j] = (map[i][j] + map[i][j - 1]) % MOD;
                }
            }
        }

        return map[n][m];
    }

    public static void main(String[] args) {
//        int m = 4;
//        int n = 3;
//        int[][] puddles = {{2, 2}};

        int m = 5;
        int n = 6;
        int[][] puddles = {{4, 1}, {1, 3}, {3, 4}, {1, 5}};
        solution(m, n, puddles);
    }
}
