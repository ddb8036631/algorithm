package 수학;

import java.util.Scanner;

public class BOJ_1212_8진수2진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] oct = sc.nextLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < oct.length; i++) {
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(ctoi(oct[i])));
            while (bin.length() != 3) bin.insert(0, 0);
            answer.append(bin);
        }

        while (idx < answer.length() && answer.charAt(idx) == '0') {
            idx++;
        }

        System.out.println(idx == answer.length() ? 0 : answer.substring(idx));
    }

    static int ctoi(char c) { return c - '0'; }
}
