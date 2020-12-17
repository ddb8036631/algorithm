package 분할정복;

import java.util.Scanner;

public class BOJ_1629_곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A, B, C;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(pow(A, B, C) % C);
    }

    public static long pow(int A, int B, int C) {
        if (B == 1) return A;
        else {
            long half = pow(A, B / 2, C);
            if (B % 2 == 0) return half * half % C;
            else return half * half % C * A % C;
        }
    }
}
