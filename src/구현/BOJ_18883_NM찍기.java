package 구현;

import java.util.Scanner;

public class BOJ_18883_NM찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(num++ + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
