package 수학;

import java.util.Scanner;

public class BOJ_11653_소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder answer = new StringBuilder();

        while (N != 1) {
            int target = 2;

            while (N % target != 0) {
                target++;
            }

            answer.append(target);
            answer.append("\n");
            N /= target;
        }

        System.out.println(answer);
    }
}
