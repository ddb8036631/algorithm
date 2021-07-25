package 구현;

import java.util.Scanner;

public class BOJ_10990_별찍기15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print('*');
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print(" ");
            }
            if (i != 0)
                System.out.print('*');
            System.out.println();
        }
    }
}
