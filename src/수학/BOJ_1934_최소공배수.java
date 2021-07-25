package 수학;

import java.util.Scanner;

public class BOJ_1934_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int GCD = gcd(Math.max(A, B), Math.min(A, B));

            System.out.println(A * B / GCD);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
