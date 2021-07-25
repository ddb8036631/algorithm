package 모의테스트;

import java.util.Scanner;

public class BOJ_1669_멍멍이쓰다듬기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int diff = Y - X;
        long n = 0;

        if (diff == 0) {
            System.out.println(0);
            return;
        }

        while (n * n < diff) n++;

        n = (n * n == diff) ? n : n - 1;
        long answer = 2 * n - 1;
        diff -= n * n;

        while (diff > 0) {
            diff -= Math.min(n, diff);
            answer++;
        }

        System.out.println(answer);
    }
}
