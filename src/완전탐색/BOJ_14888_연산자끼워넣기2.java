package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기2 {
    static int N;
    static int[] operand;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        operand = new int[N];
        for (int i = 0; i < N; i++)
            operand[i] = sc.nextInt();
        operator = new int[4];
        for (int i = 0; i < 4; i++)
            operator[i] = sc.nextInt();

        solve(1, operand[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;

            operator[i]--;
            switch (i) {
                case 0:
                    solve(depth + 1, sum + operand[depth]);
                    break;
                case 1:
                    solve(depth + 1, sum - operand[depth]);
                    break;
                case 2:
                    solve(depth + 1, sum * operand[depth]);
                    break;
                case 3:
                    solve(depth + 1, sum / operand[depth]);
                    break;
            }
            operator[i]++;
        }
    }
}
