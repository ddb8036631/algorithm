package 동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16639_괄호추가하기3 {
    static int[][] max, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();

        max = new int[N][N];
        min = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            if (Character.isDigit(s.charAt(i))) {
                max[i][i] = min[i][i] = s.charAt(i) - '0';
            }
        }

        for (int j = 2; j < N; j += 2) {
            for (int i = 0; i < N - j; i += 2) {
                for (int k = 2; k <= j; k += 2) {
                    int[] tmp = new int[4];
                    tmp[0] = cal(min[i][i + k - 2], min[i + k][i + j], s.charAt(i + k - 1));
                    tmp[1] = cal(min[i][i + k - 2], max[i + k][i + j], s.charAt(i + k - 1));
                    tmp[2] = cal(max[i][i + k - 2], min[i + k][i + j], s.charAt(i + k - 1));
                    tmp[3] = cal(max[i][i + k - 2], max[i + k][i + j], s.charAt(i + k - 1));

                    Arrays.sort(tmp);

                    min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
                    max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
                }
            }
        }

        System.out.println(max[0][N - 1]);
    }

    static int cal(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}