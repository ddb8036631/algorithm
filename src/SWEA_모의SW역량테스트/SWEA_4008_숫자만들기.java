package SWEA_모의SW역량테스트;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
    static int N;
    static int[] operator;
    static int[] operand;
    static int max;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = sc.nextInt();

            operator = new int[4];
            for (int i = 0; i < 4; i++)
                operator[i] = sc.nextInt();

            operand = new int[N];
            for (int i = 0; i < N; i++)
                operand[i] = sc.nextInt();

            solve(1, operand[0]);

            System.out.println("#" + tc + " " + (max - min));
        }
    }

    private static void solve(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0)
                continue;

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
