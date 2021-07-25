package 수학;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }

        int min = 10000;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + min);
        }
    }
}
