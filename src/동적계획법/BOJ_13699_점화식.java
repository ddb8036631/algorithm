package 동적계획법;

import java.util.Scanner;

public class BOJ_13699_점화식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] t = new long[36];

        t[0] = t[1] = 1;
        t[2] = 2;

        for (int i = 3; i <= n; i++) {
            long sum = 0;

            for (int j = 0; j < i / 2; j++) sum += t[j] * t[i - 1 - j];

            sum *= 2;
            t[i] = i % 2 == 0 ? sum : sum + t[i / 2] * t[i - i / 2 - 1];
        }

        System.out.println(t[n]);
    }
}
