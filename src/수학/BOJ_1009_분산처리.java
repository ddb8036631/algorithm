package 수학;

import java.util.Scanner;

public class BOJ_1009_분산처리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num = pow(a, b);

            System.out.println(num == 0 ? 10 : num);
        }
    }

    static int pow(int a, int e) {
        if (e == 1) return a % 10;

        int half = pow(a, e / 2) % 10;

        if (e % 2 == 0) return half * half % 10;
        else return half * half * a % 10;
    }
}
