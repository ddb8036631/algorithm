package 수학;

import java.util.Scanner;

public class BOJ_2914_저작권 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int I = sc.nextInt();

        System.out.println(A * (I - 1) + 1);
    }
}
