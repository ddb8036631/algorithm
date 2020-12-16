package 수학;

import java.util.Scanner;

public class BOJ_6064_카잉달력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int M, N, x, y;
            M = sc.nextInt();
            N = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            int cnt = -1;
            for (int m = 0; m < lcm(M, N) / M; m++) {
                if ((m * M + x - y) % N == 0) {
                    cnt = m * M + x;
                    break;
                }
            }

            System.out.println(cnt);
        }
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
