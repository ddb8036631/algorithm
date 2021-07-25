package 수학;

import java.util.Scanner;

public class BOJ_2420_사파리월드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(A > B ? A - B : B - A);
    }
}
