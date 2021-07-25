package 분할정복;

import java.util.Scanner;

public class BOJ_13171_A {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long X = sc.nextLong();

        System.out.println(pow(A, X));
    }

    static long pow(long A, long e) {
        if (e == 1) {
            return A;
        }

        long half = pow(A, e / 2) % MOD;
        System.out.println("half : " + half);

        if (e % 2 == 0) {
            return half * half % MOD;
        } else {
            return half * half * A % MOD;
        }
    }
}
