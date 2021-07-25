package 수학;

import java.util.Scanner;

public class BOJ_5543_상근날드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 2000;
        int answer = -50;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, sc.nextInt());
        }

        answer += min;
        min = 2000;

        for (int i = 0; i < 2; i++) {
            min = Math.min(min, sc.nextInt());
        }

        answer += min;
        System.out.println(answer);
    }
}
