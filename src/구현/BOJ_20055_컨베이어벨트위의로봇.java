package 구현;

import java.util.Scanner;

public class BOJ_20055_컨베이어벨트위의로봇 {
    static int N, K, SIZE;
    static int[] A;
    static boolean[] B;
    static int step, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        SIZE = 2 * N;
        A = new int[SIZE];
        B = new boolean[SIZE];

        for (int i = 0; i < SIZE; i++) A[i] = sc.nextInt();

        while (cnt < K) {
            step++;
            rotate();
            move();
            up();
        }

        System.out.println(step);
    }

    static void rotate() {
        int tmp_A = A[SIZE - 1];
        boolean tmp_B = B[SIZE - 1];

        for (int i = SIZE - 1; i >= 1; i--) {
            A[i] = A[i - 1];
            B[i] = B[i - 1];
        }

        A[0] = tmp_A;
        B[0] = tmp_B;

        if (B[N - 1]) B[N - 1] = false;
    }

    static void move() {
        for (int i = N - 2; i >= 1; i--) {
            if (!B[i]) continue;
            int next = (i + 1) % SIZE;
            if (!B[next] && A[next] >= 1) {
                if (--A[next] == 0) cnt++;

                B[i] = false;
                B[next] = next != N - 1 ? true : false;
            }
        }
    }

    static void up() {
        if (!B[0] && A[0] >= 1) {
            if (--A[0] == 0) cnt++;
            B[0] = true;
        }
    }
}
