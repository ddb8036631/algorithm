package 모의테스트;

import java.util.Scanner;

public class BOJ_1072_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();
        long Z = 100 * Y / X;

        if (99 - Z <= 0) {
            System.out.println(-1);
            return;
        }

        long q = (X * Z + X - 100 * Y) / (99 - Z);
        long r = (X * Z + X - 100 * Y) % (99 - Z);

        System.out.println(r == 0 ? q : q + 1);
    }
}
