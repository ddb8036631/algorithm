package 수학;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2960_에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[1] = false;

        outer:
        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                cnt++;

                if (cnt == K) {
                    System.out.println(i);
                    break outer;
                }

                for (int j = i * i; j <= N; j += i) {
                    if (prime[j]) {
                        prime[j] = false;
                        cnt++;

                        if (cnt == K) {
                            System.out.println(j);
                            break outer;
                        }
                    }
                }
            }
        }
    }
}
