package 분할정복;

import java.util.Scanner;

public class BOJ_13171_A_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long A = sc.nextLong();
        Long X = sc.nextLong();
        final int MOD = 1_000_000_007;
        Long answer = 1L;
        A %= MOD;

        while (X > 0) {
            if ((X & 1) == 1)
                answer = answer * A % MOD;

            X >>= 1;
            A = A * A % MOD;
        }

        System.out.println(answer);
    }
}
