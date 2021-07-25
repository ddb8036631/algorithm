package 완전탐색;

import java.util.Scanner;

public class BOJ_10819_차이를최대로 {
    static int N;
    static int[] values;
    static boolean[] used;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        values = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            used[i] = true;
            go(i, 0, 1);
            used[i] = false;
        }

        System.out.println(answer);
    }

    static void go(int now, int sum, int cnt) {
        if (cnt == N) {
            answer = Math.max(answer, sum);

            return;
        }

        for (int next = 0; next < N; next++) {
            if (!used[next]) {
                used[next] = true;
                go(next, sum + Math.abs(values[now] - values[next]), cnt + 1);
                used[next] = false;
            }
        }
    }
}
