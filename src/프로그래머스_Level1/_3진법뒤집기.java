package 프로그래머스_Level1;

import java.util.Scanner;

public class _3진법뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;

        int n = sc.nextInt();
        String three = "";
        while (n > 0) {
            three = n % 3 + three;
            n /= 3;
        }

        sb = new StringBuilder(three);
        sb = sb.reverse();

        int reverse = Integer.parseInt(sb.toString(), 3);
        System.out.println(reverse);
    }
}
