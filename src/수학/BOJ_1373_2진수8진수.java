package 수학;

import java.util.Scanner;

public class BOJ_1373_2진수8진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] bin = sc.nextLine().toCharArray();
        int len = bin.length;
        StringBuilder answer = new StringBuilder();

        if (len % 3 == 1) {
            answer.append(bin[0]);
        } else if (len % 3 == 2) {
            answer.append(ctoi(bin[0]) * 2 + ctoi(bin[1]));
        }

        for (int i = len % 3; i < len; i += 3) {
            answer.append(ctoi(bin[i]) * 4 + ctoi(bin[i + 1]) * 2 + ctoi(bin[i + 2]));
        }

        System.out.println(answer);
    }

    static int ctoi(char c) { return c - '0'; }
}
