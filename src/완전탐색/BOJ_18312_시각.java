package 완전탐색;

import java.util.Scanner;

public class BOJ_18312_시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;

        for (int hour = 0; hour <= N; hour++) {
            for (int min = 0; min <= 59; min++) {
                for (int sec = 0; sec <= 59; sec++) {
                    String tmp = String.format("%02d", hour) + String.format("%02d", min) + String.format("%02d", sec);
                    if (tmp.indexOf(String.valueOf(K)) != -1) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
