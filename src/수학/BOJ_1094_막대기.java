package 수학;

import java.util.Scanner;

public class BOJ_1094_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = Integer.toBinaryString(sc.nextInt());
        int answer = 0;

        for (int i = 0; i < X.length(); i++) if (X.charAt(i) == '1') answer++;

        System.out.println(answer);
    }
}
