package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9184_신나는함수실행 {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new int[101][101][101];

        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];

            if (a == -1 && b == -1 && c == -1) break;

            sb.append(String.format("w(%d, %d, %d) = ", a, b, c) + w(a + 50, b + 50, c + 50) + "\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a <= 50 || b <= 50 || c <= 50) return 1;
        if (a > 70 || b > 70 || c > 70) return dp[a][b][c] = w(70, 70, 70);
        if (a < b && b < c) return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
